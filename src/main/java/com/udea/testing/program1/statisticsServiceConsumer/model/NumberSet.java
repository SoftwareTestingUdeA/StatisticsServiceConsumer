package com.udea.testing.program1.statisticsServiceConsumer.model;

import java.util.List;

/**
 * @author William Hincapie - daemonsoft@gmail.com
 * @author Juan Pablo Ospina - jpoh97@gmail.com
 * @author Daniel Martinez - danielmartinezg95@gmail.com
 * @version 0.1
 */
public class NumberSet {
    String uuid;
    List<Double> set;
    NumberLinkedList list;
    Double mean;
    Double stdDeviation;

    public NumberSet() {
        mean = 0.0;
        stdDeviation = 0.0;
    }

    public List<Double> getSet() {
        return set;
    }

    public void setSet(List<Double> set) {
        this.set = set;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public NumberLinkedList getList() {
        return list;
    }

    public void setList(NumberLinkedList list) {
        this.list = list;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getStdDeviation() {
        return stdDeviation;
    }

    public void setStdDeviation(Double stdDeviation) {
        this.stdDeviation = stdDeviation;
    }

    public void calculateMean() {
        Node node = this.getList().getFirst();
        this.setMean(0.0);
        while (node != null) {
            this.mean = this.mean + node.getNumber();
            node = node.getLink();
        }

        this.mean = this.mean / this.getList().getSize();
    }

    public void calculateStdDeviation() {
        Node node = this.getList().getFirst();
        this.setStdDeviation(0.0);
        while (node != null) {
            System.out.println("nodo " + node.getNumber() + " " + this.stdDeviation + " " + this.getMean());
            this.stdDeviation = this.stdDeviation + Math.pow(node.getNumber() - this.getMean(), 2.0);
            node = node.getLink();
        }
        this.stdDeviation = Math.sqrt(stdDeviation / (this.getList().getSize() - 1));
        System.out.println("lalala " + this.stdDeviation + " " + this.getMean());
    }

    public void generateList() {
        this.setList(new NumberLinkedList());
        if (null != set)
            for (Double d : set) {
                this.getList().insert(d);
            }
    }
}
