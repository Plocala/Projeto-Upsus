package org.acme.resource;

import org.acme.DTO.ExameDTO;
import org.acme.service.ExameService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/exames")
public class ExameResource {

    @Inject
    public ExameService exameService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(exameService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(exameService.findAll()).build();
    }

    @GET
    @Path("/search/tipo/{tipo}")
    public Response findByTipo(@PathParam("tipo") String tipo) {
        return Response.ok(exameService.findByTipo(tipo)).build();
    }

    @GET
    @Path("/search/resultado/{resultado}")
    public Response findByResultado(@PathParam("resultado") String resultado) {
        return Response.ok(exameService.findByResultado(resultado)).build();
    }

    @GET
    @Path("/search/paciente/{pacienteId}")
    public Response findByPaciente(@PathParam("pacienteId") Long pacienteId) {
        return Response.ok(exameService.findByPaciente(pacienteId)).build();
    }

    @GET
    @Path("/search/profissional/{profissionalId}")
    public Response findByProfissional(@PathParam("profissionalId") Long profissionalId) {
        return Response.ok(exameService.findByProfissional(profissionalId)).build();
    }

    @POST
    public Response create(ExameDTO dto) {
        return Response.status(Status.CREATED).entity(exameService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ExameDTO dto) {
        exameService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        exameService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}