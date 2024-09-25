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
import org.SchoolApp.Web.Validators.ApprenantValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class ApprenantServiceImpl implements ApprenantService {

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReferentielRepository referentielRepository;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private ApprenantValidator apprenantValidator;

    @Override
    public ApprenantEntity createApprenant(ApprenantEntity apprenant) {
        // Valider l'apprenant
        apprenantValidator.validateApprenant(apprenant);

        UserEntity user = apprenant.getUser();

        // Générer un mot de passe par défaut et le hacher
        String defaultPassword = generateDefaultPassword();
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
        ReferentielEntity referentiel = referentielRepository.findById(apprenant.getReferentiel().getId())
                .orElseThrow(() -> new RuntimeException("Référentiel non trouvé."));
        apprenant.setReferentiel(referentiel);

        // Générer le matricule pour l'apprenant
        String matricule = generateMatricule();
        apprenant.setMatricule(matricule);

        // Générer le QR code et stocker le lien
        String qrCodeLink = qrCodeService.generateQRCode(matricule);
        apprenant.setQrCodeLink(qrCodeLink);

        // Sauvegarder l'apprenant
        ApprenantEntity savedApprenant = apprenantRepository.save(apprenant);

        // Envoyer l'email d'authentification
        emailService.sendAuthenticationEmail(user.getEmail(), user.getEmail(), defaultPassword);

        return savedApprenant;
    }

    private String generateMatricule() {
        // Générer un matricule unique
        return "MAT-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private String generateDefaultPassword() {
        // Générer un mot de passe aléatoire
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private String hashPassword(String password) {
        // Hacher le mot de passe en utilisant BCrypt ou une autre méthode sécurisée
        // Par exemple :
        // return new BCryptPasswordEncoder().encode(password);
        return password; // Placeholder, à remplacer par le hachage réel
    }
}
