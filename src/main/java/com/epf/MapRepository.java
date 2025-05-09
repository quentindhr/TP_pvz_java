package com.epf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.epf.dao.MapDAO;

@Repository
public class MapRepository implements MapDAO {

    private final JdbcTemplate jdbcTemplate;

    public MapRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createMap(Map map) {
        String sql = "INSERT INTO Map (id_map, ligne, colonne, chemin_image) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, map.getId_map(), map.getLigne(), map.getColonne(), map.getChemin_image());
    }

    @Override
    public List<Map> getAllMaps() {
        String sql = "SELECT * FROM Map";
        return jdbcTemplate.query(sql, new MapRowMapper());
    }

    @Override
    public Map getMapById(int id) {
        String sql = "SELECT * FROM Map WHERE id_map = ?";
        return jdbcTemplate.queryForObject(sql, new MapRowMapper(), id);
    }

    @Override
    public void updateMap(Map map) {
        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map = ?";
        jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getChemin_image(), map.getId_map());
    }

    @Override
    public void deleteMap(int id) {
        String sqlzombie = "DELETE FROM Zombie WHERE id_map = ?";
        jdbcTemplate.update(sqlzombie, id);
        String sql = "DELETE FROM Map WHERE id_map = ?";
        jdbcTemplate.update(sql, id);
    }

    private static final class MapRowMapper implements RowMapper<Map> {
        @Override
        public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Map(
                rs.getInt("id_map"),
                rs.getInt("ligne"),
                rs.getInt("colonne"),
                rs.getString("chemin_image")
            );
        }
    }
}

