package com.cac.proyecto;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/peliculas")
public class Controlador extends HttpServlet {
    
    //insertar pelicula
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //configuramos cabecera cors
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods","*");
        resp.setHeader("Access-Control-Allow-Headers","Content-Type");

        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        try {
            ObjectMapper mapper = new ObjectMapper();

            Pelicula peli = mapper.readValue(req.getInputStream(),Pelicula.class) ;

            //consulta sql
            String query = "INSERT INTO peliculas (titulo,fecha_estreno,genero,duracion,director,reparto,sinopsis,imagen) VALUE (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);//return generated nos da las claves generadas automaticamente

            ps.setString(1, peli.getTitulo());
            ps.setString(2, peli.getFechaEstreno());
            ps.setString(3, peli.getGenero());
            ps.setString(4, peli.getDuracion());
            ps.setString(5, peli.getDirector());
            ps.setString(6, peli.getReparto());
            ps.setString(7, peli.getSinopsis());
            ps.setString(8, peli.getImagen());

            ps.executeUpdate();//ejecutamos la consulta

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                Long idPeli = rs.getLong(1);//se obtiene el valor del primer campo
                
                //devuelve el id
                resp.setContentType("application/json");

                String json = mapper.writeValueAsString(idPeli);//convertimos id a json
                resp.getWriter().write(json);//se escribe el json en el cuerpo de la respuesta

                resp.setStatus(HttpServletResponse.SC_CREATED);//se config codigo de estado a 201



            }
        
        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch(IOException e){
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }finally{
            conexion.close();
        }
    }

    //obtener todas las pelis
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setHeader("Access-Control-Allow-Origin","*");
       resp.setHeader("Access-Control-Allow-Methods", "*");
       resp.setHeader("Access-Control-Allow-Headers", "Content-Type");

       Conexion conexion = new Conexion();
       Connection conn = conexion.getConnection();
       
       try {
        String query = "SELECT * FROM peliculas";
        Statement st = conn.createStatement();
        ResultSet rs  = st.executeQuery(query);

        List<Pelicula> peliculas = new ArrayList<>();


        while (rs.next()) {
            Pelicula peli = new Pelicula(
            rs.getInt("id_pelicula"),
            rs.getString("titulo"),
            rs.getString("fecha_estreno"),
            rs.getString("genero"),
            rs.getString("duracion"),
            rs.getString("director"),
            rs.getString("reparto"),
            rs.getString("sinopsis"),
            rs.getString("imagen"));

            peliculas.add(peli);

        }

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(peliculas);//convertimos la lista a json
    
        resp.setContentType("application/json");
        resp.getWriter().write(json);//se escribe el json en el cuerpo de la respuesta
       

        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

        }finally{
            conexion.close();
        }
    }

    //eliminar peli
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin","*");
        resp.setHeader("Access-Control-Allow-Methods","*");
        resp.setHeader("Access-Control-Allow-Headers","Content-Type");


        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();

        try {
           
            ObjectMapper mapper = new ObjectMapper();
             //mapeamos el obj pelicula
            Pelicula peli = mapper.readValue(req.getInputStream(),Pelicula.class);
            
            int idPeli = peli.getIdPelicula();
            String query = "DELETE FROM peliculas WHERE id_pelicula =?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, idPeli);

            int filas = ps.executeUpdate();

            //tipo de contendio
            resp.setContentType("application/json");
           
            if (filas>0) {
                resp.getWriter().write("pelicula eliminada con exito");
                resp.setStatus(HttpServletResponse.SC_OK);
            } else {
                resp.getWriter().write("pelicula no encontrada");
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    
        }catch(IOException e){
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }finally{
            conexion.close();
        }
    }

    //modificar por id
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setHeader("Access-Control-Allow-Origin","*");
       resp.setHeader("Access-Control-Allow-Methods","PUT");
       resp.setHeader("Access-Control-Allow-Headers","Content-Type");

       Conexion conexion = new Conexion();

       Connection conn= conexion.getConnection();

       try {
        ObjectMapper mapper = new ObjectMapper();
        Pelicula peli = mapper.readValue(req.getInputStream(),Pelicula.class);

        String query = "UPDATE  peliculas SET titulo=?,fecha_estreno=?,genero=?,duracion=?,director=?,reparto=?,sinopsis=?,imagen=? WHERE id_pelicula=?";
        
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setString(1, peli.getTitulo());
        ps.setString(2, peli.getFechaEstreno());
        ps.setString(3, peli.getGenero());
        ps.setString(4, peli.getDuracion());
        ps.setString(5, peli.getDirector());
        ps.setString(6, peli.getReparto());
        ps.setString(7, peli.getSinopsis());
        ps.setString(8, peli.getImagen()); 
        ps.setInt(9, peli.getIdPelicula());

        int filas = ps.executeUpdate();
        resp.setContentType("application/json");

        if (filas>0) {
            resp.getWriter().write("pelicula modificada con exito");
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().write("No se encontro la pelicula");
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }catch(IOException e){
        e.printStackTrace();
        resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }finally{
        conexion.close();
    }

    }
}
