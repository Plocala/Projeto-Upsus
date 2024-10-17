package org.acme.resource;

import org.acme.DTO.ProfissionalDTO;
import org.acme.service.ProfissionalService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/profissionais")
public class ProfissionalResource {

    @Inject
    public ProfissionalService profissionalService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(profissionalService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(profissionalService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(profissionalService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/formacao/{formacao}")
    public Response findByFormacao(@PathParam("formacao") String formacao) {
        return Response.ok(profissionalService.findByFormacao(formacao)).build();
    }

    @GET
    @Path("/search/especialidade/{especialidade}")
    public Response findByEspecialidade(@PathParam("especialidade") String especialidade) {
        return Response.ok(profissionalService.findByEspecialidade(especialidade)).build();
    }

    @POST
    public Response create(ProfissionalDTO dto) {
        return Response.status(Status.CREATED).entity(profissionalService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, ProfissionalDTO dto) {
        profissionalService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        profissionalService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("/login")
    public Response findByCpfAndSenha(@QueryParam("cpf") String cpf, @QueryParam("senha") String senha) {
        return Response.ok(profissionalService.findByCpfAndSenha(cpf, senha)).build();
    }


}