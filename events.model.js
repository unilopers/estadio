import { db } from './database.js';


class EventoModel {
    /**

     * @param {number} id 
     * @returns {Promise<object | null>} 
     */
    async findById(id) {
    
        const sql = 'SELECT * FROM Evento WHERE ID_EVENTO = $1';
        const result = await db.query(sql, [id]);
        return result.rows[0] || null;
    }

    /**

     * @returns {Promise<Array<object>>} 
    async findAll() {
        const sql = `
            SELECT 
                E.ID_EVENTO, 
                E.NOME, 
                E.DATA, 
                E.ID_ESTADIO, 
                S.NOME AS NOME_ESTADIO
            FROM 
                Evento E
            INNER JOIN 
                Estadio S ON E.ID_ESTADIO = S.ID_ESTADIO
            ORDER BY 
                E.DATA DESC;
        `;
        const result = await db.query(sql);
        return result.rows;
    }

    /**
     * 
     * @param {object} eventoData 
     * @returns {Promise<object>} 
     */
    async create(eventoData) {
        const { NOME, DATA, ID_ESTADIO } = eventoData;
        const sql = `
            INSERT INTO Evento (NOME, DATA, ID_ESTADIO) 
            VALUES ($1, $2, $3) 
            RETURNING *; // Retorna o registro inserido, incluindo o ID
        `;
        const result = await db.query(sql, [NOME, DATA, ID_ESTADIO]);
        return result.rows[0];
    }

    /**
    
     * @param {object} eventoData 
     * @returns {Promise<object | null>} 
     */
    async update(id, eventoData) {
        const { NOME, DATA, ID_ESTADIO } = eventoData;
        const sql = `
            UPDATE Evento 
            SET NOME = $1, DATA = $2, ID_ESTADIO = $3 
            WHERE ID_EVENTO = $4
            RETURNING *;
        `;
        const result = await db.query(sql, [NOME, DATA, ID_ESTADIO, id]);
        return result.rows[0] || null;
    }

    /**
    
     * @param {number} id 
     * @returns {Promise<boolean>} 
     */
    async delete(id) {
       
        const sql = 'DELETE FROM Evento WHERE ID_EVENTO = $1 RETURNING ID_EVENTO';
        const result = await db.query(sql, [id]);
        return result.rowCount > 0;
    }
}

export const Evento = new EventoModel();