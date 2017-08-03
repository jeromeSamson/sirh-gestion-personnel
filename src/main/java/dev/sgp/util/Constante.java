package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.VisiteService;

public interface Constante {
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	VisiteService VISITE_SERVICE = new VisiteService();
	DepartementService DEPARTEMENT_SERVICE = new DepartementService();
}
