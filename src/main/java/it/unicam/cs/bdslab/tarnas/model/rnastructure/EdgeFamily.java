package it.unicam.cs.bdslab.tarnas.model.rnastructure;

import java.util.Objects;

public class EdgeFamily {
    private String base_id_5p;
    private String base_id_3p;
    private EdgeFamilyValues canonical_bond;
    private String bond_type;
    private EdgeFamilyValues cis_or_trans;

    public EdgeFamily(String base_id_5p, String base_id_3p, EdgeFamilyValues canonical_bond, String bond_type, EdgeFamilyValues cis_or_trans) {
        this.base_id_5p = base_id_5p;
        this.base_id_3p = base_id_3p;
        this.canonical_bond = canonical_bond;
        this.bond_type = bond_type;
        this.cis_or_trans = cis_or_trans;
    }

    // Getters
    public String getBaseId5p() { return base_id_5p; }
    public String getBaseId3p() { return base_id_3p; }
    public EdgeFamilyValues getCanonicalBond() { return canonical_bond; }
    public String getBondType() { return bond_type; }
    public EdgeFamilyValues getCisOrTrans() { return cis_or_trans; }

    // Setters
    public void setBaseId5p(String base_id_5p) { this.base_id_5p = base_id_5p; }
    public void setBaseId3p(String base_id_3p) { this.base_id_3p = base_id_3p; }
    public void setCanonicalBond(EdgeFamilyValues canonical_bond) { this.canonical_bond = canonical_bond; }
    public void setBondType(String bond_type) { this.bond_type = bond_type; }
    public void setCisOrTrans(EdgeFamilyValues cis_or_trans) { this.cis_or_trans = cis_or_trans; }

    // equals(), hashCode() and toString()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EdgeFamily that = (EdgeFamily) o;
        return Objects.equals(base_id_5p, that.base_id_5p) &&
                Objects.equals(base_id_3p, that.base_id_3p) &&
                canonical_bond == that.canonical_bond &&
                Objects.equals(bond_type, that.bond_type) &&
                cis_or_trans == that.cis_or_trans;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base_id_5p, base_id_3p, canonical_bond, bond_type, cis_or_trans);
    }

    @Override
    public String toString() {
        return "EdgeFamily{" +
                "base_id_5p='" + base_id_5p + '\'' +
                ", base_id_3p='" + base_id_3p + '\'' +
                ", canonical_bond=" + canonical_bond +
                ", bond_type='" + bond_type + '\'' +
                ", cis_or_trans=" + cis_or_trans +
                '}';
    }
}