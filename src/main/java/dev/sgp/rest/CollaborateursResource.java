package dev.sgp.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@Path("/collaborateurs")
public class CollaborateursResource {
	@Inject
	CollaborateurService collabSer;
	@Inject
	DepartementService depServ;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Collaborateur> list(@QueryParam("departement") Integer dep) {
		if (dep == null) {
			return collabSer.listerCollaborateurs();

		} else {
			return collabSer.listerCollaborateurByDep(dep);
		}
	}

	@GET
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object findCollabByMatri(@PathParam("matricule") String matricule) {
		Collaborateur co = collabSer.getCollabByMatricule(matricule);
		if (co == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return co;
		}

	}

	@PUT
	@Path("/{matricule}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCollab(@PathParam("matricule") String matricule, @QueryParam("adresse") String adresse,
			@QueryParam("banque") String banque, @QueryParam("bic") String bic, @QueryParam("iban") String iban,
			@QueryParam("telephone") String tel, @QueryParam("departement") Integer id,
			@QueryParam("intitulePoste") String intitulePoste) {

		Map<String, Object> params = new HashMap<>();
		params.put("matricule", matricule);
		params.put("banque", banque);
		params.put("adresse", adresse);
		params.put("bic", bic);
		params.put("iban", iban);
		params.put("telephone", tel);
		params.put("departement", id);
		params.put("intitulePoste", intitulePoste);

		List<String> notFound = params.entrySet().stream().filter(p -> p.getValue() == null).map(p -> p.getKey())
				.collect(Collectors.toList());
		if (!notFound.isEmpty()) {

			JsonObject jo = Json.createObjectBuilder().add("non_renseigne", "[" + String.join(", ", notFound) + "]")
					.build();
			return Response.status(400).entity(jo).build();

		} else {
			List<Departement> listDep = depServ.listerDepartement();
			Departement departement = listDep.get(id);

			Collaborateur col = collabSer.getCollabByMatricule(matricule);
			col.setActif(true);
			col.setAdresse(adresse);
			col.setBanque(banque);
			col.setBic(bic);
			col.setTel(tel);
			col.setDepartement(departement);
			col.setIban(iban);
			col.setIntitulePoste(intitulePoste);

			collabSer.updateCollaborateur(col);
			return Response.status(Response.Status.OK).build();

		}

	}

	@GET
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getBanqueByMatricule(@PathParam("matricule") String matricule) {
		Collaborateur collab = collabSer.getCollabByMatricule(matricule);
		if (collab.getBanque() == null || collab.getBic() == null || collab.getIban() == null) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity("Des informations concernant la banque sont manquantes veuillez editer le collaborateur : "
							+ collab.getNom().toUpperCase() + " " + collab.getPrenom())
					.build();
		} else {
			JsonObject jo = Json.createObjectBuilder().add("banque", collab.getBanque()).add("bic", collab.getBic())
					.add("iban", collab.getIban()).build();
			return jo;
		}

	}

	@PUT
	@Path("/{matricule}/banque")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateCoordBanque(@PathParam("matricule") String matricule, @QueryParam("banque") String banque,
			@QueryParam("bic") String bic, @QueryParam("iban") String iban) {
		Map<String, Object> params = new HashMap<>();
		params.put("matricule", matricule);
		params.put("banque", banque);
		params.put("bic", bic);
		params.put("iban", iban);
		List<String> notFound = params.entrySet().stream().filter(p -> p.getValue() == null).map(p -> p.getKey())
				.collect(Collectors.toList());
		if (!notFound.isEmpty()) {

			JsonObject jo = Json.createObjectBuilder().add("non_renseigne", "[" + String.join(", ", notFound) + "]")
					.build();
			return Response.status(400).entity(jo).build();

		} else {

			Collaborateur collab = collabSer.getCollabByMatricule(matricule);
			collab.setBanque(banque);
			collab.setBic(bic);
			collab.setIban(iban);
			collabSer.updateBanque(collab);
			return Response.status(200).build();
		}

	}

}
