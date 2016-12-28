package resposity;

import model.Organization;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/28.
 */
@Repository
public class OrganizationRepository extends BaseRepository<Organization> {
    @Override
    public void save(Organization organization) {
        super.save(organization);
    }
}

