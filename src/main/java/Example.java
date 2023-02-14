import com.microsoft.z3.*;

public class Example {
    public static void main(String[] args) {
        Context ctx = new Context();

        // Declare integer constants
        IntExpr xw01 = ctx.mkIntConst("xw01");
        IntExpr yw01 = ctx.mkIntConst("yw01");
        IntExpr xw21 = ctx.mkIntConst("xw21");
        IntExpr xw23 = ctx.mkIntConst("xw23");
        IntExpr xw25 = ctx.mkIntConst("xw25");
        IntExpr xw27 = ctx.mkIntConst("xw27");
        //xw32
        IntExpr xw32 = ctx.mkIntConst("xw32");
        //xw34
        IntExpr xw34 = ctx.mkIntConst("xw34");
        //xw31
        IntExpr xw31 = ctx.mkIntConst("xw31");
        IntExpr xw12 = ctx.mkIntConst("xw12");
        IntExpr xw14 = ctx.mkIntConst("xw14");
        IntExpr xw41 = ctx.mkIntConst("xw41");
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
                ctx.mkImplies(ctx.mkEq(xr11, xw21),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw21), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25),
                                        ctx.mkEq(xr13, xw27), ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw21), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25),
                                        ctx.mkEq(xr15, xw27), ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                ctx.mkImplies(ctx.mkEq(xr11, xw23),
                        ctx.mkAnd(ctx.mkOr(ctx.mkEq(xr13, xw12), ctx.mkEq(xr13, xw23), ctx.mkEq(xr13, xw25), ctx.mkEq(xr13, xw27),
                                        ctx.mkEq(xr13, xw32), ctx.mkEq(xr13, xw34)),
                                ctx.mkOr(ctx.mkEq(xr15, xw14), ctx.mkEq(xr15, xw23), ctx.mkEq(xr15, xw25), ctx.mkEq(xr15, xw27),
                                        ctx.mkEq(xr15, xw32), ctx.mkEq(xr15, xw34)))),
                ctx.mkAnd(ctx.mkEq(xw41, ctx.mkInt(3)), ctx.mkEq(yw41, ctx.mkInt(3)))
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
