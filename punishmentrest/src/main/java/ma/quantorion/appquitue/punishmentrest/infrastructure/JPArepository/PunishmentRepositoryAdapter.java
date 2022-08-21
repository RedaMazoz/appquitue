package ma.quantorion.appquitue.punishmentrest.infrastructure.JPArepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.quantorion.appquitue.punishmentrest.domain.Punishment;
import ma.quantorion.appquitue.punishmentrest.domain.PunishmentRepository;

@Component
public class PunishmentRepositoryAdapter implements PunishmentRepository {
	private final PunishmentJPARepository punishmentRepository;

    @Autowired
    public PunishmentRepositoryAdapter(final PunishmentJPARepository punishmentRepository) {
        this.punishmentRepository = punishmentRepository;
    }

    @Override
    public Optional<Punishment> findById(Long id) {
        Optional<PunishmentEntity> punishmentEntity = punishmentRepository.findById(id);
        if (punishmentEntity.isPresent()) {
            return Optional.of(punishmentEntity.get().toPunishment());
        } else {
            return Optional.empty();
        }
    }

	@Override
	public List<Punishment> findAll() {
		return 
		punishmentRepository.findAll()
        .stream()
        .map(punishmentEntity ->
          punishmentEntity.toPunishment())
        .collect(Collectors.toList());
	}

	@Override
	public Punishment save(Punishment punishment) {
		punishmentRepository.save(new PunishmentEntity(punishment));
		return punishment;
	}

	@Override
	public void deleteById(Long id) {
		punishmentRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
    

}
