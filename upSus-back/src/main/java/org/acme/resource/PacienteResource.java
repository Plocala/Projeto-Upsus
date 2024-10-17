package org.acme.resource;

import org.acme.DTO.PacienteDTO;
import org.acme.service.PacienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/pacientes")
public class PacienteResource {

    @Inject
    public PacienteService pacienteService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(pacienteService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(pacienteService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(pacienteService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/nomeMae/{nomeMae}")
    public Response findByNomeMae(@PathParam("nomeMae") String nomeMae) {
        return Response.ok(pacienteService.findByNomeMae(nomeMae)).build();
    }

    @GET
    @Path("/search/dataNascimento")
    public Response findByDataNascimento(@QueryParam("dataInicio") String dataInicio, @QueryParam("dataFim") String dataFim) {
        return Response.ok(pacienteService.findByDataNascimento(dataInicio, dataFim)).build();
    }

    @GET
    @Path("/search/dataUltimaConsulta")
    public Response findByLastConsult(@QueryParam("dataInicio") String dataInicio, @QueryParam("dataFim") String dataFim) {
        return Response.ok(pacienteService.findByLastConsult(dataInicio, dataFim)).build();
    }

    @GET
    @Path("/search/cartaoSus/{cartaoSus}")
    public Response findByCartaoSus(@PathParam("cartaoSus") String cartaoSus) {
        return Response.ok(pacienteService.findByCartaoSus(cartaoSus)).build();
    }

    @GET
    @Path("/search/cpf/{cpf}")
    public Response findByCpf(@PathParam("cpf") String cpf) {
        return Response.ok(pacienteService.findByCpf(cpf)).build();
    }

    @GET
    @Path("/search/sexo/{sexo}")
    public Response findBySexo(@PathParam("sexo") boolean sexo) {
        return Response.ok(pacienteService.findBySexo(sexo)).build();
    }

    @GET
    @Path("/search/obs/{obs}")
    public Response findByObs(@PathParam("obs") String obs) {
        return Response.ok(pacienteService.findByObs(obs)).build();
    }

    @POST
    public Response create(PacienteDTO dto) {
        return Response.status(Status.CREATED).entity(pacienteService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, PacienteDTO dto) {
        pacienteService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        pacienteService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @POST
    @Path("/{id}/tarefas/{idTarefa}")
    public Response adicionarTarefa(@PathParam("id") Long id, @PathParam("idTarefa") Long idTarefa) {
        pacienteService.adicionarTarefa(id, idTarefa);
        return Response.status(Status.NO_CONTENT).build();
    }
}