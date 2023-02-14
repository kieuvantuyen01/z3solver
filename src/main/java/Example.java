import com.microsoft.z3.*;

public class Example {
    public static void main(String[] args) {
        Context ctx = new Context();

        // Declare write variables for x
        //xw01
        IntExpr xw01 = ctx.mkIntConst("xw01");
        //xw21
        IntExpr xw21 = ctx.mkIntConst("xw21");
        //xw23
        IntExpr xw23 = ctx.mkIntConst("xw23");
        //xw25
        IntExpr xw25 = ctx.mkIntConst("xw25");
        //xw27
        IntExpr xw27 = ctx.mkIntConst("xw27");
        //xw32
        IntExpr xw32 = ctx.mkIntConst("xw32");
        //xw34
        IntExpr xw34 = ctx.mkIntConst("xw34");
        //xw31
        IntExpr xw31 = ctx.mkIntConst("xw31");
        //xw12
        IntExpr xw12 = ctx.mkIntConst("xw12");
        //xw14
        IntExpr xw14 = ctx.mkIntConst("xw14");
        //xw41
        IntExpr xw41 = ctx.mkIntConst("xw41");

        // Declare write variables for y
        //yw01
        IntExpr yw01 = ctx.mkIntConst("yw01");
        //yw13
        IntExpr yw13 = ctx.mkIntConst("yw13");
        //yw15
        IntExpr yw15 = ctx.mkIntConst("yw15");
        //yw22
        IntExpr yw22 = ctx.mkIntConst("yw22");
        //yw24
        IntExpr yw24 = ctx.mkIntConst("yw24");
        //yw26
        IntExpr yw26 = ctx.mkIntConst("yw26");
        //yw32
        IntExpr yw32 = ctx.mkIntConst("yw32");
        //yw34
        IntExpr yw34 = ctx.mkIntConst("yw34");
        //yw36
        IntExpr yw36 = ctx.mkIntConst("yw36");
        //yw41
        IntExpr yw41 = ctx.mkIntConst("yw41");

        // Declare read variables for x
        //x11
        IntExpr xr11 = ctx.mkIntConst("xr11");
        //x13
        IntExpr xr13 = ctx.mkIntConst("xr13");
        //x15
        IntExpr xr15 = ctx.mkIntConst("xr15");
        //x22
        IntExpr xr22 = ctx.mkIntConst("xr22");
        //x24
        IntExpr xr24 = ctx.mkIntConst("xr24");
        //x26
        IntExpr xr26 = ctx.mkIntConst("xr26");
        //x31
        IntExpr xr31 = ctx.mkIntConst("xr31");
        //x33
        IntExpr xr33 = ctx.mkIntConst("xr33");
        //x35
        IntExpr xr35 = ctx.mkIntConst("xr35");

        // Declare read variables for y
        //yr12
        IntExpr yr12 = ctx.mkIntConst("yr12");
        //yr14
        IntExpr yr14 = ctx.mkIntConst("yr14");
        //yr21
        IntExpr yr21 = ctx.mkIntConst("yr21");
        //yr23
        IntExpr yr23 = ctx.mkIntConst("yr23");
        //yr25
        IntExpr yr25 = ctx.mkIntConst("yr25");
        //yr27
        IntExpr yr27 = ctx.mkIntConst("yr27");
        //yr31
        IntExpr yr31 = ctx.mkIntConst("yr31");
        //yr33
        IntExpr yr33 = ctx.mkIntConst("yr33");
        //yr35
        IntExpr yr35 = ctx.mkIntConst("yr35");

        Solver solver = ctx.mkSolver();
        BoolExpr[] allConstraints = {
                ctx.mkEq(xw01, ctx.mkInt(1)),
                ctx.mkEq(yw01, ctx.mkInt(1)),
                // Ràng buộc cho xr11
                ctx.mkOr(ctx.mkEq(xr11, xw01), ctx.mkEq(xr11, xw21), ctx.mkEq(xr11, xw23), ctx.mkEq(xr11, xw25),
                        ctx.mkEq(xr11, xw27), ctx.mkEq(xr11, xw32), ctx.mkEq(xr11, xw34)),
                // Ràng buộc cho xr13
                ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw21), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25),
                        ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                // Ràng buộc cho xr15
                ctx.mkOr(
                        ctx.mkEq(xr15, xw14),
                        ctx.mkEq(xr15, xw21),
                        ctx.mkEq(xr15, xw23),
                        ctx.mkEq(xr15, xw25),
                        ctx.mkEq(xr15, xw27),
                        ctx.mkEq(xr15, xw32),
                        ctx.mkEq(xr15, xw34)
                ),
                // Ràng buộc cho xr22
                ctx.mkOr(
                        ctx.mkEq(xr22, xw01),
                        ctx.mkEq(xr22, xw12),
                        ctx.mkEq(xr22, xw14),
                        ctx.mkEq(xr22, xw32),
                        ctx.mkEq(xr22, xw34)
                ),
                //Ràng buộc cho xr24
                ctx.mkOr(
                        ctx.mkEq(xr24, xw23),
                        ctx.mkEq(xr24, xw12),
                        ctx.mkEq(xr24, xw14),
                        ctx.mkEq(xr24, xw32),
                        ctx.mkEq(xr24, xw34)
                ),
                // Ràng buộc cho xr26
                ctx.mkOr(
                        ctx.mkEq(xr26, xw25),
                        ctx.mkEq(xr26, xw12),
                        ctx.mkEq(xr26, xw14),
                        ctx.mkEq(xr26, xw32),
                        ctx.mkEq(xr26, xw34)
                ),
                // Ràng buộc cho xr31
                ctx.mkOr(
                        ctx.mkEq(xr31, xw01),
                        ctx.mkEq(xr31, xw12),
                        ctx.mkEq(xr31, xw14),
                        ctx.mkEq(xr31, xw21),
                        ctx.mkEq(xr31, xw23),
                        ctx.mkEq(xr31, xw25),
                        ctx.mkEq(xr31, xw27)
                ),
                // Ràng buộc cho xr33
                ctx.mkOr(
                        ctx.mkEq(xr33, xw31),
                        ctx.mkEq(xr33, xw12),
                        ctx.mkEq(xr33, xw14),
                        ctx.mkEq(xr33, xw21),
                        ctx.mkEq(xr33, xw23),
                        ctx.mkEq(xr33, xw25),
                        ctx.mkEq(xr33, xw27)
                ),
                // Ràng buộc cho xr35
                ctx.mkOr(
                        ctx.mkEq(xr35, xw31),
                        ctx.mkEq(xr35, xw12),
                        ctx.mkEq(xr35, xw14),
                        ctx.mkEq(xr35, xw21),
                        ctx.mkEq(xr35, xw23),
                        ctx.mkEq(xr35, xw25),
                        ctx.mkEq(xr35, xw27)
                ),
                //xr11&xw21
                ctx.mkImplies(ctx.mkEq(xr11, xw21),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw21), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25),
                                        ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                        ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr11&xw23
                ctx.mkImplies(ctx.mkEq(xr11, xw23),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25), ctx.mkEq(xr13, xw27),
                                        ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25), ctx.mkEq(xr15, xw27),
                                        ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr11&xw25
                ctx.mkImplies(ctx.mkEq(xr11, xw25),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw25), ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32),
                                        ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw25), ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32),
                                        ctx.mkEq(xr15, xw34)))),
                //xr11&xw27
                ctx.mkImplies(ctx.mkEq(xr11, xw27),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr11&xw32
                ctx.mkImplies(ctx.mkEq(xr11, xw32),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw21), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25),
                                        ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                        ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr11&xw34
                ctx.mkImplies(ctx.mkEq(xr11, xw34),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw21), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25),
                                        ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                        ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw34)))),
                //xr13&xw21
                ctx.mkImplies(ctx.mkEq(xr13, xw21),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr13&xw23
                ctx.mkImplies(ctx.mkEq(xr13, xw23),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25), ctx.mkEq(xr15, xw27),
                                ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr13&xw25
                ctx.mkImplies(ctx.mkEq(xr13, xw25),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw25), ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32),
                                ctx.mkEq(xr15, xw34)))),
                //xr13&xw27
                ctx.mkImplies(ctx.mkEq(xr13, xw27),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr13&xw32
                ctx.mkImplies(ctx.mkEq(xr13, xw32),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                //xr13&xw34
                ctx.mkImplies(ctx.mkEq(xr13, xw34),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw34)))),
                //xr22&xw12
                ctx.mkImplies(ctx.mkEq(xr22, xw12),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr24, xw23), ctx.mkEq(xr24, xw12), ctx.mkEq(xr24, xw14), ctx.mkEq(xr24, xw32),
                                        ctx.mkEq(xr24, xw34)),
                                ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                        ctx.mkEq(xr26, xw34)))),
                //xr22&xw14
                ctx.mkImplies(ctx.mkEq(xr22, xw14),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr24, xw23), ctx.mkEq(xr24, xw14), ctx.mkEq(xr24, xw32),
                                        ctx.mkEq(xr24, xw34)),
                                ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                        ctx.mkEq(xr26, xw34)))),
                //xr22&xw32
                ctx.mkImplies(ctx.mkEq(xr22, xw32),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr24, xw23), ctx.mkEq(xr24, xw12), ctx.mkEq(xr24, xw14), ctx.mkEq(xr24, xw32),
                                        ctx.mkEq(xr24, xw34)),
                                ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                        ctx.mkEq(xr26, xw34)))),
                //xr22&xw34
                ctx.mkImplies(ctx.mkEq(xr22, xw34),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr24, xw23), ctx.mkEq(xr24, xw12), ctx.mkEq(xr24, xw14),
                                        ctx.mkEq(xr24, xw34)),
                                ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14),
                                        ctx.mkEq(xr26, xw34)))),
                //xr24&xw12
                ctx.mkImplies(ctx.mkEq(xr24, xw12),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                ctx.mkEq(xr26, xw34)))),
                //xr24&xw14
                ctx.mkImplies(ctx.mkEq(xr24, xw14),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                ctx.mkEq(xr26, xw34)))),
                //xr24&xw32
                ctx.mkImplies(ctx.mkEq(xr24, xw32),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14), ctx.mkEq(xr26, xw32),
                                ctx.mkEq(xr26, xw34)))),
                //xr24&xw34
                ctx.mkImplies(ctx.mkEq(xr24, xw34),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr26, xw25), ctx.mkEq(xr26, xw12), ctx.mkEq(xr26, xw14),
                                ctx.mkEq(xr26, xw34)))),
                //xr31&xw12
                ctx.mkImplies(ctx.mkEq(xr31, xw12),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw12), ctx.mkEq(xr33, xw14), ctx.mkEq(xr33, xw21),
                                        ctx.mkEq(xr33, xw23), ctx.mkEq(xr33, xw25), ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr31&xw14
                ctx.mkImplies(ctx.mkEq(xr31, xw14),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw14), ctx.mkEq(xr33, xw21),
                                        ctx.mkEq(xr33, xw23), ctx.mkEq(xr33, xw25), ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr31&xw21
                ctx.mkImplies(ctx.mkEq(xr31, xw21),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw12), ctx.mkEq(xr33, xw14), ctx.mkEq(xr33, xw21),
                                        ctx.mkEq(xr33, xw23), ctx.mkEq(xr33, xw25), ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr31&xw23
                ctx.mkImplies(ctx.mkEq(xr31, xw23),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw12), ctx.mkEq(xr33, xw14),
                                        ctx.mkEq(xr33, xw23), ctx.mkEq(xr33, xw25), ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr31&xw25
                ctx.mkImplies(ctx.mkEq(xr31, xw25),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw12), ctx.mkEq(xr33, xw14),
                                        ctx.mkEq(xr33, xw25), ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr31&xw27
                ctx.mkImplies(ctx.mkEq(xr31, xw27),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr33, xw32), ctx.mkEq(xr33, xw12), ctx.mkEq(xr33, xw14),
                                        ctx.mkEq(xr33, xw27)),
                                ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw27)))),
                //xr33&xw12
                ctx.mkImplies(ctx.mkEq(xr33, xw12),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr33&xw14
                ctx.mkImplies(ctx.mkEq(xr33, xw14),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr33&xw21
                ctx.mkImplies(ctx.mkEq(xr33, xw21),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14), ctx.mkEq(xr35, xw21),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr33&xw23
                ctx.mkImplies(ctx.mkEq(xr33, xw23),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw23), ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr33&xw25
                ctx.mkImplies(ctx.mkEq(xr33, xw25),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw25), ctx.mkEq(xr35, xw27)))),
                //xr33&xw27
                ctx.mkImplies(ctx.mkEq(xr33, xw27),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr35, xw34), ctx.mkEq(xr35, xw12), ctx.mkEq(xr35, xw14),
                                        ctx.mkEq(xr35, xw27)))),
                //ctx.mkAnd(ctx.mkEq(xw41, ctx.mkInt(3)), ctx.mkEq(yw41, ctx.mkInt(3)))
                ctx.mkAnd(ctx.mkEq(xw41, ctx.mkInt(3)))
        };
        solver.add(allConstraints);

        if (solver.check() == Status.SATISFIABLE) {
            Model model = solver.getModel();
            System.out.println("Solution found:");
            System.out.println("xr11 = " + model.evaluate(xr11, false));
            System.out.println("xr13 = " + model.evaluate(xr13, false));
            System.out.println("xr15 = " + model.evaluate(xr15, false));
        } else {
            System.out.println("The constraints are unsatisfiable.");
        }
    }
}
