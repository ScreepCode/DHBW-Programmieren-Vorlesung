package de.niklas.exams.cts_extra_exam_2019;
public enum GreenhouseGas {

    CARBON_DIOXIDE("Carbon dioxide", 1),
    METHANE("Methane", 25),
    NITROUS_OXIDE("Nitrous Oxide", 298);

    private final String name;
    private final int globalWarmingPotential;

    GreenhouseGas(String name, int globalWarmingPotential) {
        this.name = name;
        this.globalWarmingPotential = globalWarmingPotential;
    }

    public String getName() {
        return name;
    }

    public int getGlobalWarmingPotential() {
        return globalWarmingPotential;
    }

    @Override
    public String toString() {
        return String.format("%s", name);
    }
}