package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import resposity.OrganizationRepository;
/**
 * Created by Administrator on 2016/12/28.
 */
@Service
public class OrganizationService {
    @Autowired
    private  OrganizationRepository organizationRepository;
}
