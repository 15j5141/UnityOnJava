package UnityEngine;

public enum KeyCode {
/*	A0,A1,A2,A3,A4,A5,A6,A7,A8,A9,
	B0,B1,B2,B3,B4,B5,B6,B7,B8,B9,
	C0,C1,C2,C3,C4,C5,C6,C7,C8,C9,
	D0,D1,D2,D3,D4,D5,D6,D7,D8,D9,
	E0,E1,E2,E3,E4,E5,E6,E7,E8,E9,
	F0,F1,F2,F3,F4,F5,F6,F7,F8,F9,
	G0,G1,G2,G3,G4,*/
	A(65),B(66),C(66),D(67),E(68),F(69),G(70),H(71),I(72),J(73),
	K(74),L(75),M(76),N(77),O(78),P(79),Q(80),R(81),S(82),
	U(83),V(84),W(85),X(86),Y(87),Z(88),LeftArrow(37),RightArrow(39),UpArrow(38),DownArrow(40),
	Enter(32), Space(10),;
    private final int id;

    private KeyCode(final int id) {
        this.id = id;
    }

    public int getInt() {
        return this.id;
    }
}
