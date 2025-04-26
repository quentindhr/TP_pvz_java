package com.epf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.dao.ZombieDAO;

@Repository
public class ZombieRepository implements ZombieDAO {

    private final JdbcTemplate jdbcTemplate;

    public ZombieRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createZombie(Zombie zombie) {
        String sql = "INSERT INTO Zombie (id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, zombie.getId_zombie(), zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(), zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map());
    }

    @Override
    public List<Zombie> getAllZombies() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, new ZombieRowMapper());
    }

    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new ZombieRowMapper(), id);
    }

    @Override
    public void updateZombie(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, vitesse_de_deplacement = ?, chemin_image = ?, id_map = ? WHERE id_zombie = ?";
        jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(), zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image(), zombie.getId_map(), zombie.getId_zombie());
    }

    @Override
    public void deleteZombie(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Zombie> getZombiesByMapId(int mapId) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, new ZombieRowMapper(), mapId);
    }

    private static final class ZombieRowMapper implements RowMapper<Zombie> {
        @Override
        public Zombie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Zombie(
                rs.getInt("id_zombie"),
                rs.getString("nom"),
                rs.getInt("point_de_vie"),
                rs.getFloat("attaque_par_seconde"),
                rs.getInt("degat_attaque"),
                rs.getFloat("vitesse_de_deplacement"),
                rs.getString("chemin_image"),
                rs.getInt("id_map")
            );
        }
    }
}

