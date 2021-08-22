package com.cinema.sessionservice.service;

import com.cinema.sessionservice.DTO.SessionDTO;
import com.cinema.sessionservice.model.Session;
import com.cinema.sessionservice.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    SessionRepository sessionRepository;

    @Autowired
    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Session createSession(SessionDTO sessionDTO){
        Session session = new Session();
        session.setSeats(sessionDTO.getSeats());
        session.setFreeSeats(sessionDTO.getSeats());
        session.setFilmId(sessionDTO.getFilmId());
        session.setStartTime(sessionDTO.getStartTime());
        session.setEndTime(session.getStartTime().plusMinutes((long)(sessionDTO.getFilmTime() * 60)));

        return sessionRepository.save(session);
    }

    public Session getSession(int id){
        return sessionRepository.findById(id).get();
    }

    public Session updateSession(int id, SessionDTO sessionDTO){
        sessionRepository.updateSession(sessionDTO.getFilmId(),
                sessionDTO.getStartTime(),
                sessionDTO.getStartTime().plusMinutes((long)(sessionDTO.getFilmTime() * 60)),
                id);

     return getSession(id);
    }

    public void deleteSession(int id){
        sessionRepository.deleteById(id);
    }
}
