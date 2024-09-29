package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.ApprenantEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Datas.Enums.StatusEnum;
import org.SchoolApp.Datas.Repository.ApprenantRepository;
import org.SchoolApp.Datas.Repository.ReferentielRepository;
import org.SchoolApp.Datas.Repository.UserRepository;
import org.SchoolApp.Services.Interfaces.ApprenantService;
import org.SchoolApp.Services.Interfaces.EmailService;
import org.SchoolApp.Services.Interfaces.QRCodeService;
import org.SchoolApp.Web.Dtos.Mapper.ApprenantMapper;
import org.SchoolApp.Web.Dtos.Request.ApprenantRequestDto;
import org.SchoolApp.Web.Dtos.Response.ApprenantResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import prog.dependancy.Services.AbstractService;
import prog.dependancy.Web.Mappper.GenericMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ApprenantService2 extends AbstractService<ApprenantEntity, ApprenantRequestDto, ApprenantResponseDto> implements ApprenantService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReferentielRepository referentielRepository;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    public ApprenantService2(ApprenantRepository repository, ApprenantMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Value("${myapp.secret.student}")
    private String studentSecret;
    @Override
    public Optional<ApprenantResponseDto> findById(Long id) {
        return super.findById(id);  // This uses the implementation from AbstractService
    }

    @Override
    public List<ApprenantResponseDto> findAll() {
        return super.findAll();  // This uses the implementation from AbstractService
    }

    @Override
    public ApprenantResponseDto save(ApprenantRequestDto apprenantDto) {
        ApprenantEntity apprenant =mapper.toEntity(apprenantDto);
        UserEntity user = userRepository.findById(apprenantDto.getUserId()).orElseThrow();

        // Générer un mot de passe par défaut et le hacher
        String defaultPassword = studentSecret;
        user.setPassword(hashPassword(defaultPassword));

        // Définir le statut par défaut si non défini
        if (user.getStatus() == null) {
            user.setStatus(StatusEnum.ACTIF);
        }

        // Sauvegarder l'utilisateur
        userRepository.save(user);

        // Associer l'utilisateur à l'apprenant
        apprenant.setUser(user);

        // Récupérer le référentiel depuis la base de données
        ReferentielEntity referentiel = referentielRepository.findById(apprenantDto.getReferentielId())
                .orElseThrow(() -> new RuntimeException("Référentiel non trouvé."));
        apprenant.setReferentiel(referentiel);

        // Générer le matricule pour l'apprenant
        String matricule = generateMatricule();
        apprenant.setMatricule(matricule);

        // Générer le QR code et stocker le lien
        String qrCodeLink = qrCodeService.generateQRCode(matricule);
        apprenant.setQrCodeLink(qrCodeLink);

        // Sauvegarder l'apprenant
        ApprenantEntity savedApprenant = repository.save(apprenant);

        // Envoyer l'email d'authentification
        emailService.sendAuthenticationEmail(user.getEmail(), user.getEmail(), defaultPassword);

        return mapper.toDto(savedApprenant);  // This uses the implementation from AbstractService
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);  // This uses the implementation from AbstractService
    }

    @Override
    public ApprenantResponseDto update(Long id, ApprenantRequestDto apprenantDto) {
        apprenantDto.setId(id);  // Ensure the ID is set for the update
        return super.update(id, apprenantDto);  // This uses the implementation from AbstractService
    }

    @Override
    public ApprenantEntity createApprenant(ApprenantEntity apprenant, Long userId, Long referentielId) {
        return null;
    }
    private String generateMatricule() {
        return "MAT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }



    private String hashPassword(String password) {
         return new BCryptPasswordEncoder().encode(password);
    }
}
