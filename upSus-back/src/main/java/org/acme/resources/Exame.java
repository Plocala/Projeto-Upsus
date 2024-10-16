package br.unitins.topicos1.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.topicos1.dto.ExameDTO;
import br.unitins.topicos1.service.ExameServiceImpl;

@Path("/autorManga")
public class ExameResource {
    
    @Inject ExameServiceImpl autorMangaService;

    @GET
     public Response findAll() {
        return Response.ok(autorMangaService.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id")long id) {
        return Response.ok(autorMangaService.findById(id)).build();
    }

    @GET
    @Path("/name/{name}")
    public Response findByName(@PathParam("name")String name) {
        return Response.ok(autorMangaService.findByName(name)).build();
    }

    @GET
    @Path("/manga/{mangaId}")
    public Response findByManga(@PathParam("mangaId")long mangaId) {
        return Response.ok(autorMangaService.findByManga(mangaId)).build();
    }

    @POST
    public Response create(ExameDTO autorManga) {
        return Response.status(Status.CREATED).entity(autorMangaService.create(autorManga)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long id, ExameDTO autorManga) {
        autorMangaService.update(id, autorManga);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        autorMangaService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
