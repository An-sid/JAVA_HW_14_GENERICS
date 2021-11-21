package ru.netology.manager;

import ru.netology.domain.Proposal;
import ru.netology.repository.ProposalRepository;

import java.util.ArrayList;
import java.util.Arrays;

public class ProposalManager {
    private ProposalRepository repo;

    public ProposalManager(ProposalRepository repository) {
        this.repo = repository;
    }

    public boolean matches(Proposal proposal, String depAir, String arrAir) {
        return proposal.getDepAir().contains(depAir) & proposal.getArrtAir().contains(arrAir);
    }

    public Proposal[] findAll(String depAir, String arrAir) {
        Proposal[] result = new Proposal[0];
        ArrayList<Proposal> list = new ArrayList<>();
        for (Proposal proposal : repo.getItems()) {
            if (matches(proposal, depAir, arrAir)) {
                list.add(proposal);
            }
            result = list.toArray(new Proposal[list.size()]);
            Arrays.sort(result);
        }
        return result;
    }

}






















