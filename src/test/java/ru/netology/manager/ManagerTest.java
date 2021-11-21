package ru.netology.manager;

import ru.netology.domain.Proposal;
import ru.netology.repository.ProposalRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    //testData
    Proposal prop1 = new Proposal(1, 3100, "SVO", "VKO", 95);
    Proposal prop2 = new Proposal(2, 3100, "VKO", "KZN", 95);
    Proposal prop22 = new Proposal(22, 3200, "VKO", "KZN", 95);
    Proposal prop222 = new Proposal(222, 3000, "VKO", "KZN", 95);
    Proposal[] testData = {prop1, prop2, prop22, prop222};
    //
    ProposalRepository repo = new ProposalRepository();
    ProposalManager mng = new ProposalManager(repo);

    @Test
    void searchByConditions() {
        repo.fillRepo(testData);
        Proposal[] expected = new Proposal[]{prop1};
        Proposal[] actual = mng.findAll("SVO", "VKO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void sortByPrice() {
        repo.fillRepo(testData);
        Proposal[] expected = new Proposal[]{prop222, prop2, prop22};
        Proposal[] actual = mng.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByWrongConditions() {
        repo.fillRepo(testData);
        Proposal[] expected = new Proposal[0];
        Proposal[] actual = mng.findAll("XXX", "XXX");
        assertArrayEquals(expected, actual);
    }

}