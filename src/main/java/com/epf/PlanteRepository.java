package com.epf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.dao.PlanteDAO;

@Repository
public class PlanteRepository implements PlanteDAO {

    private final JdbcTemplate jdbcTemplate;

    public PlanteRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createPlante(Plante plante) {
        String sql = "INSERT INTO Plante (id_plante, nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, plante.getId_plante(), plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet().name(), plante.getChemin_image());
    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, new PlanteRowMapper());
    }

    @Override
    public Plante getPlanteById(String id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new PlanteRowMapper(), id);
    }

    @Override
    public void updatePlante(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?";
        jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet().name(), plante.getChemin_image(), plante.getId_plante());
    }

    @Override
    public void deletePlante(String id) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class PlanteRowMapper implements RowMapper<Plante> {
        @Override
        public Plante mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Plante(
                rs.getString("id_plante"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getFloat("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getInt("cout"),
                rs.getInt("soleil_par_seconde"),
                Plante.effet.valueOf(rs.getString("effet")),
                rs.getString("chemin_image")
            );
        }
    }
}
