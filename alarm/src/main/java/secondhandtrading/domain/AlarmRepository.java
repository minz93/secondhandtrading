package secondhandtrading.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import secondhandtrading.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "alarms", path = "alarms")
public interface AlarmRepository
    extends PagingAndSortingRepository<Alarm, Long> {}
