import { Evento } from '../models/events.model.js';

class EventoController {

    async getAllEvents(req, res) {
        try {
            const eventos = await Evento.findAll();
            return res.status(200).json(eventos);
        } catch (error) {
            console.error('Erro ao buscar eventos:', error);
            return res.status(500).json({ message: 'Erro interno ao buscar eventos.' });
        }
    }

    async getEventById(req, res) {
        const id = parseInt(req.params.id);
        if (isNaN(id)) {
            return res.status(400).json({ message: 'ID de evento inválido.' });
        }

        try {
            const evento = await Evento.findById(id);

            if (!evento) {
                return res.status(404).json({ message: 'Evento não encontrado.' });
            }

            return res.status(200).json(evento);
        } catch (error) {
            console.error(`Erro ao buscar evento ${id}:`, error);
            return res.status(500).json({ message: 'Erro interno ao buscar evento.' });
        }
    }

    async createEvent(req, res) {
        const { NOME, DATA, ID_ESTADIO } = req.body;

        if (!NOME || !DATA || !ID_ESTADIO) {
            return res.status(400).json({ message: 'Campos NOME, DATA e ID_ESTADIO são obrigatórios.' });
        }

        try {
            const novoEvento = await Evento.create({ NOME, DATA, ID_ESTADIO });
            return res.status(201).json(novoEvento);
        } catch (error) {
            console.error('Erro ao criar evento:', error);
            return res.status(500).json({ message: 'Erro interno ao criar evento.' });
        }
    }

    async updateEvent(req, res) {
        const id = parseInt(req.params.id);
        const { NOME, DATA, ID_ESTADIO } = req.body;

        if (isNaN(id) || (!NOME && !DATA && !ID_ESTADIO)) {
             return res.status(400).json({ message: 'ID inválido ou nenhum dado para atualização.' });
        }

        try {
            const eventoAtualizado = await Evento.update(id, { NOME, DATA, ID_ESTADIO });

            if (!eventoAtualizado) {
                return res.status(404).json({ message: 'Evento não encontrado para atualização.' });
            }

            return res.status(200).json(eventoAtualizado);
        } catch (error) {
            console.error(`Erro ao atualizar evento ${id}:`, error);
            return res.status(500).json({ message: 'Erro interno ao atualizar evento.' });
        }
    }

    async deleteEvent(req, res) {
        const id = parseInt(req.params.id);

        if (isNaN(id)) {
            return res.status(400).json({ message: 'ID de evento inválido.' });
        }

        try {
            const deleted = await Evento.delete(id);

            if (!deleted) {
                return res.status(404).json({ message: 'Evento não encontrado para exclusão.' });
            }

            return res.status(204).send();
        } catch (error) {
            console.error(`Erro ao deletar evento ${id}:`, error);
            return res.status(500).json({ message: 'Erro interno ao excluir evento. Verifique se existem ingressos vinculados.' });
        }
    }
}

export const EventoController = new EventoController();