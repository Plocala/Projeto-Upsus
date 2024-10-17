package org.acme.resource;

import org.acme.DTO.TarefaDTO;
import org.acme.service.TarefaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tarefas")
public class TarefaResource {

    @Inject
    public TarefaService tarefaService;

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(tarefaService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(tarefaService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(tarefaService.findByNome(nome)).build();
    }

    @GET
    @Path("/search/descricao/{descricao}")
    public Response findByDescricao(@PathParam("descricao") String descricao) {
        return Response.ok(tarefaService.findByDescricao(descricao)).build();
    }

    @GET
    @Path("/search/status/{status}")
    public Response findByStatus(@PathParam("status") String status) {
        return Response.ok(tarefaService.findByStatus(status)).build();
    }
    
    @POST
    public Response create(TarefaDTO dto) {
        return Response.status(Status.CREATED).entity(tarefaService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TarefaDTO dto) {
        tarefaService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        tarefaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}