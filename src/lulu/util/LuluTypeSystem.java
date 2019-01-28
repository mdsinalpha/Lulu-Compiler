package lulu.util;

import lulu.model.types.LuluArrayType;
import lulu.model.types.LuluFunctionType;
import lulu.model.types.LuluObjectType;
import lulu.model.types.LuluPrimitiveType;
import lulu.model.types.LuluType;
import lulu.parser.LuluLexer;

/**
 *
 * @author hashemi
 */
public class LuluTypeSystem {

    public static int UNDEFINED = -10;
    public static int NIL = 99;
    public static String NIL_TAG = "nil";
    public static int FUNCTION = 100;
    public static int ARRAY = 101;
    public static int OBJECT = 102;
    public static String OBJECT_TAG = "object";
    private static int TYPE_COUNTER = 102;

    public static Integer getNextObjectTypeCode() {
        return TYPE_COUNTER++;
    }
    
    public static LuluType type(LuluType operand, Integer operator){
        return new LuluPrimitiveType(type(operand.getTypeCode(), operator));
    }
    
    public static LuluType type(LuluType operand1, LuluType operand2, Integer operator){
        return new LuluPrimitiveType(type(operand1.getTypeCode(), operand2.getTypeCode(), operator));
    }

    public static Integer type(Integer operand, Integer operator) {
        switch (operator) {
            case LuluLexer.UNARY_OP:
                if (operand == LuluLexer.BOOL_CONST || operand == LuluLexer.INT_CONST) {
                    return LuluLexer.BOOL_CONST;
                }
                break;
            case LuluLexer.MINUS:
                if (operand == LuluLexer.INT_CONST || operand == LuluLexer.REAL_CONST) {
                    return operand;
                }
                break;
            case LuluLexer.BITWISE_NOT:
                if (operand == LuluLexer.BOOL_CONST || operand == LuluLexer.INT_CONST) {
                    return LuluLexer.INT_CONST;
                }
        }
        return UNDEFINED;
    }

    public static Integer type(Integer operand1, Integer operand2, Integer operator) {
        switch (operator) {
            case LuluLexer.ARIT_P1:
                Integer t1 = type1(operand1, operand2);
                return t1 == UNDEFINED ? type2(operand1, operand2) : t1;
            case LuluLexer.ARIT_P2:
                Integer t2 = type1(operand1, operand2);
                return t2 == UNDEFINED ? type2(operand1, operand2) : t2;
            case LuluLexer.BITWISE_AND:
                return type2(operand1, operand2);
            case LuluLexer.BITWISE_OR:
                return type2(operand1, operand2);
            case LuluLexer.BITWISE_XOR:
                return type2(operand1, operand2);
            case LuluLexer.LOGICAL_AND:
                return type3(operand1, operand2);
            case LuluLexer.LOGICAL_OR:
                return type3(operand1, operand2);
            case LuluLexer.REL:
                Integer t3 = type4(operand1, operand2);
                Integer t4 = type3(operand1, operand2);
                return t3 == UNDEFINED ? (t4 == UNDEFINED ? type5(operand1, operand2) : t4) : t3;
            case LuluLexer.REL_EQ:
                Integer t5 = type4(operand1, operand2);
                Integer t6 = type3(operand1, operand2);
                return t5 == UNDEFINED ? (t6 == UNDEFINED ? type5(operand1, operand2) : t6) : t5;

        }
        return UNDEFINED;
    }

    private static Integer type1(Integer operand1, Integer operand2) {
        if (operand1 == LuluLexer.REAL_CONST && (operand2 == LuluLexer.BOOL_CONST
                || operand2 == LuluLexer.INT_CONST
                || operand2 == LuluLexer.REAL_CONST)
                || operand2 == LuluLexer.REAL_CONST && (operand1 == LuluLexer.BOOL_CONST
                || operand1 == LuluLexer.INT_CONST)) {
            return LuluLexer.REAL_CONST;
        }
        return UNDEFINED;
    }

    private static Integer type2(Integer operand1, Integer operand2) {
        if (operand1 == LuluLexer.BOOL_CONST && (operand2 == LuluLexer.INT_CONST
                || operand2 == LuluLexer.BOOL_CONST)
                || operand1 == LuluLexer.INT_CONST && (operand2 == LuluLexer.BOOL_CONST
                || operand2 == LuluLexer.INT_CONST)) {
            return LuluLexer.INT_CONST;
        }
        return UNDEFINED;
    }

    private static Integer type3(Integer operand1, Integer operand2) {
        if (operand1 == LuluLexer.BOOL_CONST && (operand2 == LuluLexer.INT_CONST
                || operand2 == LuluLexer.BOOL_CONST)
                || operand1 == LuluLexer.INT_CONST && (operand2 == LuluLexer.BOOL_CONST
                || operand2 == LuluLexer.INT_CONST)) {
            return LuluLexer.BOOL_CONST;
        }
        return UNDEFINED;
    }

    private static Integer type4(Integer operand1, Integer operand2) {
        if (operand1 == LuluLexer.REAL_CONST && (operand2 == LuluLexer.BOOL_CONST
                || operand2 == LuluLexer.INT_CONST
                || operand2 == LuluLexer.REAL_CONST)
                || operand2 == LuluLexer.REAL_CONST && (operand1 == LuluLexer.BOOL_CONST
                || operand1 == LuluLexer.INT_CONST)) {
            return LuluLexer.BOOL_CONST;
        }
        return UNDEFINED;
    }

    private static Integer type5(Integer operand1, Integer operand2) {
        if (operand1 == LuluLexer.STRING_CONST && (operand2 == LuluLexer.BOOL_CONST
                || operand2 == LuluLexer.STRING_CONST)
                || operand2 == LuluLexer.STRING_CONST && operand1 == LuluLexer.BOOL_CONST) {
            return LuluLexer.BOOL_CONST;
        }
        return UNDEFINED;
    }
    
    public static boolean convertable(LuluPrimitiveType source, LuluPrimitiveType destination){
        return convertable(source.getTypeCode(), destination.getTypeCode());
    }

    public static boolean convertable(Integer source, Integer destination) {
        switch (destination) {
            case LuluLexer.REAL_CONST:
                if (source == LuluLexer.REAL_CONST || source == LuluLexer.INT_CONST) {
                    return true;
                }
                break;
            case LuluLexer.INT_CONST:
                if (source == LuluLexer.BOOL_CONST || source == LuluLexer.INT_CONST) {
                    return true;
                }
                break;
            case LuluLexer.BOOL_CONST:
                if (source == LuluLexer.BOOL_CONST || source == LuluLexer.INT_CONST) {
                    return true;
                }
                break;
            case LuluLexer.STRING_CONST:
                if (source == LuluLexer.STRING_CONST || source == LuluLexer.BOOL_CONST) {
                    return true;
                }
                break;
        }
        return false;
    }

    public static boolean convertable(LuluObjectType source, LuluObjectType destination) {
        LuluObjectType temp = source;
        while (!temp.getTypeCode().equals(OBJECT)) {
            if (temp.getTypeCode().equals(destination.getTypeCode())) {
                return true;
            }
            temp = (LuluObjectType) temp.getSuperType();
        }
        return false;
    }

    public static boolean convertable(LuluArrayType source, LuluArrayType destination) {
        if (source.getDimensions().equals(destination.getDimensions())) {
                return source.convertable(destination);
        }
        return false;
    }

    public static boolean convertable(LuluFunctionType source, LuluFunctionType destination){
        if (source.inputTypes.size() != destination.inputTypes.size()) {
            return false;
        }
        if (source.outputTypes.size() != destination.outputTypes.size()) {
            return false;
        }
        for (int i = 0; i < source.inputTypes.size(); i++) {
                if(!source.inputTypes.get(i).convertable(destination.inputTypes.get(i)))
                    return false;
        }
        for (int i = 0; i < source.outputTypes.size(); i++) {
                if(!source.outputTypes.get(i).convertable(destination.outputTypes.get(i)))
                    return false;
        }
        return true;
    }

}
