package org.una.tramites.services;

/**
 *
 * @author Sergio
 */
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tramites.entities.TramiteTipo;
import org.una.tramites.repositories.ITramiteTipoRepository;

/**
 *
 * @author chris
 */
@Service
public class TramiteTipoServiceImplementation implements ITramiteTipoService {

    @Autowired
    private ITramiteTipoRepository tramiteTipoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<TramiteTipo> findById(Long id) {
        return tramiteTipoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByDepartamentoId(Long departamentoId) {
        return tramiteTipoRepository.findByDepartamentoId(departamentoId);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByEstado(boolean estado) {
        return tramiteTipoRepository.findByEstado(estado);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TramiteTipo>> findByFechaRegistroBetween(Date startDate, Date endDate) {
        return tramiteTipoRepository.findByFechaRegistroBetween(startDate, endDate);
    }

    @Override
    @Transactional
    public TramiteTipo create(TramiteTipo tramiteTipo) {
        return tramiteTipoRepository.save(tramiteTipo);
    }

    @Override
    @Transactional
    public Optional<TramiteTipo> update(TramiteTipo tramiteTipo, Long id) {
        if (tramiteTipoRepository.findById(id).isPresent()) {
            return Optional.ofNullable(tramiteTipoRepository.save(tramiteTipo));
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        tramiteTipoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        tramiteTipoRepository.deleteAll();
    }

    @Transactional(readOnly = true)
    public Optional login(TramiteTipo tramiteTipo) {
        return Optional.ofNullable(tramiteTipoRepository.findById(tramiteTipo.getId()));
    }

}
