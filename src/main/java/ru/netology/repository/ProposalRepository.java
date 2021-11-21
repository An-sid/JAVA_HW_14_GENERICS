package ru.netology.repository;

import ru.netology.domain.Proposal;

public class ProposalRepository {
    public Proposal[] getItems() {
        return items;
    }

    public Proposal[] items = new Proposal[0];

    public void fillRepo(Proposal[] data) {
        items = data;
    }

    public void save(Proposal item) {
        int length = items.length + 1;
        Proposal[] tmp = new Proposal[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Proposal findById(int id) {
        for (Proposal item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Proposal[] tmp = new Proposal[length];
        int index = 0;
        for (Proposal item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}

