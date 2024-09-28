package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.ApprenantEntity;

public interface ApprenantService {
    ApprenantEntity createApprenant(ApprenantEntity apprenant,Long userId,Long referentielId);
}
