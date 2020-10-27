package com.raft.repo.sightly;
import java.util.List;
import com.raft.repo.repo_without.*;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = IgitSight.class, immediate = true)
public class GitSightImpl implements IgitSight {

    @Reference
    private Igit repoFetcher;

    public List<String> getRepositories() {
        List<String> githubRepositories = repoFetcher.getRepositories();
        return githubRepositories;
    }

}