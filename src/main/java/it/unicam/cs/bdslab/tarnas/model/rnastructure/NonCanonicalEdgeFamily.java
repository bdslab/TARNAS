package it.unicam.cs.bdslab.tarnas.model.rnastructure;

import java.util.Objects;

public class NonCanonicalEdgeFamily {
    private String base_id_5p;
    private int base_id_5p_index;
    private String base_id_3p;
    private int base_id_3p_index;
    private NonCanonicalEdgeFamilyValues bond_type1;
    private NonCanonicalEdgeFamilyValues bond_type2;
    private NonCanonicalEdgeFamilyValues bondOrientation;

    public NonCanonicalEdgeFamily(String base_id_5p, int base_id_5p_index, String base_id_3p, int base_id_3p_index, NonCanonicalEdgeFamilyValues bond_type1, NonCanonicalEdgeFamilyValues bond_type2, NonCanonicalEdgeFamilyValues bondOrientation) {
        this.base_id_5p = base_id_5p;
        this.base_id_5p_index = base_id_5p_index;
        this.base_id_3p = base_id_3p;
        this.base_id_3p_index = base_id_3p_index;
        this.bond_type1 = bond_type1;
        this.bond_type2 = bond_type2;
        this.bondOrientation = bondOrientation;
    }

    // Setters
    public String getBase_id_5p() {
        return base_id_5p;
    }

    public int getBase_id_5p_index() {
        return base_id_5p_index;
    }

    public String getBase_id_3p() {
        return base_id_3p;
    }

    public int getBase_id_3p_index() {
        return base_id_3p_index;
    }

    public NonCanonicalEdgeFamilyValues getBond_type1() {
        return bond_type1;
    }

    public NonCanonicalEdgeFamilyValues getBond_type2() {
        return bond_type2;
    }

    public NonCanonicalEdgeFamilyValues getBondOrientation() {
        return bondOrientation;
    }

    // Setters
    public void setBase_id_5p(String base_id_5p) {
        this.base_id_5p = base_id_5p;
    }

    public void setBase_id_5p_index(int base_id_5p_index) {
        this.base_id_5p_index = base_id_5p_index;
    }

    public void setBase_id_3p(String base_id_3p) {
        this.base_id_3p = base_id_3p;
    }

    public void setBase_id_3p_index(int base_id_3p_index) {
        this.base_id_3p_index = base_id_3p_index;
    }

    public void setBond_type1(NonCanonicalEdgeFamilyValues bond_type1) {
        this.bond_type1 = bond_type1;
    }

    public void setBond_type2(NonCanonicalEdgeFamilyValues bond_type2) {
        this.bond_type2 = bond_type2;
    }

    public void setBondOrientation(NonCanonicalEdgeFamilyValues bondOrientation) {
        this.bondOrientation = bondOrientation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        NonCanonicalEdgeFamily that = (NonCanonicalEdgeFamily) o;
        return getBase_id_5p_index() == that.getBase_id_5p_index() && getBase_id_3p_index() == that.getBase_id_3p_index() && Objects.equals(getBase_id_5p(), that.getBase_id_5p()) && Objects.equals(getBase_id_3p(), that.getBase_id_3p()) && getBond_type1() == that.getBond_type1() && getBond_type2() == that.getBond_type2() && getBondOrientation() == that.getBondOrientation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBase_id_5p(), getBase_id_5p_index(), getBase_id_3p(), getBase_id_3p_index(), getBond_type1(), getBond_type2(), getBondOrientation());
    }

    @Override
    public String toString() {
        return "NonCanonicalEdgeFamily{" +
                "base_id_5p='" + base_id_5p + '\'' +
                ", base_id_5p_index=" + base_id_5p_index +
                ", base_id_3p='" + base_id_3p + '\'' +
                ", base_id_3p_index=" + base_id_3p_index +
                ", bond_type1=" + bond_type1 +
                ", bond_type2=" + bond_type2 +
                ", bondOrientation=" + bondOrientation +
                '}';
    }
}