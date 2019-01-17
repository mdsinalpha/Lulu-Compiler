// Generated from Lulu.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LuluParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, BOOL_CONST=33, PRIM_TYPE=34, ACCSSMOD=35, ID=36, UNARY_OP=37, 
		MINUS=38, ARIT_P1=39, ARIT_P2=40, BITWISE_AND=41, BITWISE_OR=42, BITWISE_XOR=43, 
		LOGICAL_AND=44, LOGICAL_OR=45, REL=46, REL_EQ=47, STRING_CONST=48, REAL_CONST=49, 
		INT_CONST=50, WHITESPACE=51, LINE_COMMENT=52, COMMENT=53;
	public static final int
		RULE_program = 0, RULE_ft_dcl = 1, RULE_func_dcl = 2, RULE_args = 3, RULE_args_var = 4, 
		RULE_type_dcl = 5, RULE_var_def = 6, RULE_var_val = 7, RULE_ft_def = 8, 
		RULE_type_def = 9, RULE_component = 10, RULE_func_def = 11, RULE_block = 12, 
		RULE_stmt = 13, RULE_assign = 14, RULE_var = 15, RULE_ref = 16, RULE_expr = 17, 
		RULE_func_call = 18, RULE_list = 19, RULE_handle_call = 20, RULE_params = 21, 
		RULE_cond_stmt = 22, RULE_loop_stmt = 23, RULE_const_val = 24, RULE_type = 25;
	public static final String[] ruleNames = {
		"program", "ft_dcl", "func_dcl", "args", "args_var", "type_dcl", "var_def", 
		"var_val", "ft_def", "type_def", "component", "func_def", "block", "stmt", 
		"assign", "var", "ref", "expr", "func_call", "list", "handle_call", "params", 
		"cond_stmt", "loop_stmt", "const_val", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'declare'", "'{'", "'}'", "'('", "')'", "'='", "';'", "'['", "']'", 
		"','", "'const'", "'type'", "':'", "'function'", "'return'", "'break'", 
		"'continue'", "'destruct'", "'this'", "'super'", "'.'", "'allocate'", 
		"'nil'", "'read'", "'write'", "'if'", "'else'", "'switch'", "'case'", 
		"'default'", "'for'", "'while'", null, null, null, null, null, "'-'", 
		null, "'+'", "'&'", "'|'", "'^'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "BOOL_CONST", "PRIM_TYPE", 
		"ACCSSMOD", "ID", "UNARY_OP", "MINUS", "ARIT_P1", "ARIT_P2", "BITWISE_AND", 
		"BITWISE_OR", "BITWISE_XOR", "LOGICAL_AND", "LOGICAL_OR", "REL", "REL_EQ", 
		"STRING_CONST", "REAL_CONST", "INT_CONST", "WHITESPACE", "LINE_COMMENT", 
		"COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Lulu.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LuluParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public Ft_dclContext ft_dcl() {
			return getRuleContext(Ft_dclContext.class,0);
		}
		public List<Ft_defContext> ft_def() {
			return getRuleContexts(Ft_defContext.class);
		}
		public Ft_defContext ft_def(int i) {
			return getRuleContext(Ft_defContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(52);
				ft_dcl();
				}
			}

			setState(56); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(55);
				ft_def();
				}
				}
				setState(58); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__13))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ft_dclContext extends ParserRuleContext {
		public List<Func_dclContext> func_dcl() {
			return getRuleContexts(Func_dclContext.class);
		}
		public Func_dclContext func_dcl(int i) {
			return getRuleContext(Func_dclContext.class,i);
		}
		public List<Type_dclContext> type_dcl() {
			return getRuleContexts(Type_dclContext.class);
		}
		public Type_dclContext type_dcl(int i) {
			return getRuleContext(Type_dclContext.class,i);
		}
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public Ft_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ft_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFt_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFt_dcl(this);
		}
	}

	public final Ft_dclContext ft_dcl() throws RecognitionException {
		Ft_dclContext _localctx = new Ft_dclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ft_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
			setState(61);
			match(T__1);
			setState(65); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(65);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(62);
					func_dcl();
					}
					break;
				case 2:
					{
					setState(63);
					type_dcl();
					}
					break;
				case 3:
					{
					setState(64);
					var_def();
					}
					break;
				}
				}
				setState(67); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__10) | (1L << PRIM_TYPE) | (1L << ID))) != 0) );
			setState(69);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_dclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public Args_varContext args_var() {
			return getRuleContext(Args_varContext.class,0);
		}
		public Func_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFunc_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFunc_dcl(this);
		}
	}

	public final Func_dclContext func_dcl() throws RecognitionException {
		Func_dclContext _localctx = new Func_dclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_func_dcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(71);
				match(T__3);
				setState(72);
				args(0);
				setState(73);
				match(T__4);
				setState(74);
				match(T__5);
				}
			}

			setState(78);
			match(ID);
			setState(79);
			match(T__3);
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(80);
				args(0);
				}
				break;
			case 2:
				{
				setState(81);
				args_var(0);
				}
				break;
			}
			setState(84);
			match(T__4);
			setState(85);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		return args(0);
	}

	private ArgsContext args(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgsContext _localctx = new ArgsContext(_ctx, _parentState);
		ArgsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_args, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(88);
			type();
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					match(T__7);
					setState(90);
					match(T__8);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(108);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_args);
					setState(96);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(97);
					match(T__9);
					setState(98);
					type();
					setState(103);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(99);
							match(T__7);
							setState(100);
							match(T__8);
							}
							} 
						}
						setState(105);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
					}
					}
					} 
				}
				setState(110);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Args_varContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public Args_varContext args_var() {
			return getRuleContext(Args_varContext.class,0);
		}
		public Args_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterArgs_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitArgs_var(this);
		}
	}

	public final Args_varContext args_var() throws RecognitionException {
		return args_var(0);
	}

	private Args_varContext args_var(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Args_varContext _localctx = new Args_varContext(_ctx, _parentState);
		Args_varContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_args_var, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(112);
			type();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(113);
				match(T__7);
				setState(114);
				match(T__8);
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Args_varContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_args_var);
					setState(122);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(123);
					match(T__9);
					setState(124);
					type();
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(125);
						match(T__7);
						setState(126);
						match(T__8);
						}
						}
						setState(131);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(132);
					match(ID);
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Type_dclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public Type_dclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_dcl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterType_dcl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitType_dcl(this);
		}
	}

	public final Type_dclContext type_dcl() throws RecognitionException {
		Type_dclContext _localctx = new Type_dclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type_dcl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(ID);
			setState(140);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_defContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Var_valContext> var_val() {
			return getRuleContexts(Var_valContext.class);
		}
		public Var_valContext var_val(int i) {
			return getRuleContext(Var_valContext.class,i);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterVar_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitVar_def(this);
		}
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_var_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(142);
				match(T__10);
				}
			}

			setState(145);
			type();
			setState(146);
			var_val();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(147);
				match(T__9);
				setState(148);
				var_val();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_valContext extends ParserRuleContext {
		public RefContext ref() {
			return getRuleContext(RefContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Var_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterVar_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitVar_val(this);
		}
	}

	public final Var_valContext var_val() throws RecognitionException {
		Var_valContext _localctx = new Var_valContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_var_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			ref();
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(157);
				match(T__5);
				setState(158);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ft_defContext extends ParserRuleContext {
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public Func_defContext func_def() {
			return getRuleContext(Func_defContext.class,0);
		}
		public Ft_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ft_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFt_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFt_def(this);
		}
	}

	public final Ft_defContext ft_def() throws RecognitionException {
		Ft_defContext _localctx = new Ft_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ft_def);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(161);
				type_def();
				}
				break;
			case T__3:
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(162);
				func_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_defContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LuluParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LuluParser.ID, i);
		}
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public Type_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterType_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitType_def(this);
		}
	}

	public final Type_defContext type_def() throws RecognitionException {
		Type_defContext _localctx = new Type_defContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__11);
			setState(166);
			match(ID);
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(167);
				match(T__12);
				setState(168);
				match(ID);
				}
			}

			setState(171);
			match(T__1);
			setState(173); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				component();
				}
				}
				setState(175); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__10) | (1L << T__13) | (1L << PRIM_TYPE) | (1L << ACCSSMOD) | (1L << ID))) != 0) );
			setState(177);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentContext extends ParserRuleContext {
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Func_defContext func_def() {
			return getRuleContext(Func_defContext.class,0);
		}
		public TerminalNode ACCSSMOD() { return getToken(LuluParser.ACCSSMOD, 0); }
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitComponent(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCSSMOD) {
				{
				setState(179);
				match(ACCSSMOD);
				}
			}

			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case PRIM_TYPE:
			case ID:
				{
				setState(182);
				var_def();
				}
				break;
			case T__3:
			case T__13:
				{
				setState(183);
				func_def();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_defContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<Args_varContext> args_var() {
			return getRuleContexts(Args_varContext.class);
		}
		public Args_varContext args_var(int i) {
			return getRuleContext(Args_varContext.class,i);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFunc_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFunc_def(this);
		}
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(186);
				match(T__3);
				setState(187);
				args_var(0);
				setState(188);
				match(T__4);
				setState(189);
				match(T__5);
				}
			}

			setState(193);
			match(T__13);
			setState(194);
			match(ID);
			setState(195);
			match(T__3);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIM_TYPE || _la==ID) {
				{
				setState(196);
				args_var(0);
				}
			}

			setState(199);
			match(T__4);
			setState(200);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<Var_defContext> var_def() {
			return getRuleContexts(Var_defContext.class);
		}
		public Var_defContext var_def(int i) {
			return getRuleContext(Var_defContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(T__1);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__10) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__30) | (1L << T__31) | (1L << PRIM_TYPE) | (1L << ID))) != 0)) {
				{
				setState(205);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(203);
					var_def();
					}
					break;
				case 2:
					{
					setState(204);
					stmt();
					}
					break;
				}
				}
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(210);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public Cond_stmtContext cond_stmt() {
			return getRuleContext(Cond_stmtContext.class,0);
		}
		public Loop_stmtContext loop_stmt() {
			return getRuleContext(Loop_stmtContext.class,0);
		}
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		int _la;
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				assign();
				setState(213);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				func_call();
				setState(216);
				match(T__6);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				cond_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				loop_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
				match(T__14);
				setState(221);
				match(T__6);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(222);
				match(T__15);
				setState(223);
				match(T__6);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(224);
				match(T__16);
				setState(225);
				match(T__6);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(226);
				match(T__17);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(227);
					match(T__7);
					setState(228);
					match(T__8);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(234);
				match(ID);
				setState(235);
				match(T__6);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<VarContext> var() {
			return getRuleContexts(VarContext.class);
		}
		public VarContext var(int i) {
			return getRuleContext(VarContext.class,i);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(250);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case ID:
				{
				setState(238);
				var();
				}
				break;
			case T__3:
				{
				setState(239);
				match(T__3);
				setState(240);
				var();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(241);
					match(T__9);
					setState(242);
					var();
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(248);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(252);
			match(T__5);
			setState(253);
			expr(0);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarContext extends ParserRuleContext {
		public List<RefContext> ref() {
			return getRuleContexts(RefContext.class);
		}
		public RefContext ref(int i) {
			return getRuleContext(RefContext.class,i);
		}
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_var);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18 || _la==T__19) {
				{
				setState(255);
				_la = _input.LA(1);
				if ( !(_la==T__18 || _la==T__19) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(256);
				match(T__20);
				}
			}

			setState(259);
			ref();
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(260);
					match(T__20);
					setState(261);
					ref();
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitRef(this);
		}
	}

	public final RefContext ref() throws RecognitionException {
		RefContext _localctx = new RefContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ref);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ID);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(268);
					match(T__7);
					setState(269);
					expr(0);
					setState(270);
					match(T__8);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode UNARY_OP() { return getToken(LuluParser.UNARY_OP, 0); }
		public TerminalNode MINUS() { return getToken(LuluParser.MINUS, 0); }
		public Handle_callContext handle_call() {
			return getRuleContext(Handle_callContext.class,0);
		}
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Const_valContext const_val() {
			return getRuleContext(Const_valContext.class,0);
		}
		public TerminalNode ARIT_P1() { return getToken(LuluParser.ARIT_P1, 0); }
		public TerminalNode ARIT_P2() { return getToken(LuluParser.ARIT_P2, 0); }
		public TerminalNode BITWISE_AND() { return getToken(LuluParser.BITWISE_AND, 0); }
		public TerminalNode BITWISE_XOR() { return getToken(LuluParser.BITWISE_XOR, 0); }
		public TerminalNode BITWISE_OR() { return getToken(LuluParser.BITWISE_OR, 0); }
		public TerminalNode REL() { return getToken(LuluParser.REL, 0); }
		public TerminalNode REL_EQ() { return getToken(LuluParser.REL_EQ, 0); }
		public TerminalNode LOGICAL_AND() { return getToken(LuluParser.LOGICAL_AND, 0); }
		public TerminalNode LOGICAL_OR() { return getToken(LuluParser.LOGICAL_OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(278);
				match(T__3);
				setState(279);
				expr(0);
				setState(280);
				match(T__4);
				}
				break;
			case 2:
				{
				setState(282);
				match(UNARY_OP);
				setState(283);
				expr(18);
				}
				break;
			case 3:
				{
				setState(284);
				match(MINUS);
				setState(285);
				expr(17);
				}
				break;
			case 4:
				{
				setState(286);
				match(T__21);
				setState(287);
				handle_call();
				}
				break;
			case 5:
				{
				setState(288);
				func_call();
				}
				break;
			case 6:
				{
				setState(289);
				var();
				}
				break;
			case 7:
				{
				setState(290);
				list();
				}
				break;
			case 8:
				{
				setState(291);
				match(T__22);
				}
				break;
			case 9:
				{
				setState(292);
				const_val();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(327);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(325);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(296);
						match(ARIT_P1);
						setState(297);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(299);
						match(ARIT_P2);
						setState(300);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(302);
						match(MINUS);
						setState(303);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(305);
						match(BITWISE_AND);
						setState(306);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(308);
						match(BITWISE_XOR);
						setState(309);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(311);
						match(BITWISE_OR);
						setState(312);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(314);
						match(REL);
						setState(315);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(317);
						match(REL_EQ);
						setState(318);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(320);
						match(LOGICAL_AND);
						setState(321);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(323);
						match(LOGICAL_OR);
						setState(324);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(329);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Func_callContext extends ParserRuleContext {
		public Handle_callContext handle_call() {
			return getRuleContext(Handle_callContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFunc_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFunc_call(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_func_call);
		try {
			setState(346);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case T__19:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(333);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(330);
					var();
					setState(331);
					match(T__20);
					}
					break;
				}
				setState(335);
				handle_call();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 2);
				{
				setState(336);
				match(T__23);
				setState(337);
				match(T__3);
				setState(338);
				var();
				setState(339);
				match(T__4);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				match(T__24);
				setState(342);
				match(T__3);
				setState(343);
				var();
				setState(344);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ListContext> list() {
			return getRuleContexts(ListContext.class);
		}
		public ListContext list(int i) {
			return getRuleContext(ListContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(348);
			match(T__7);
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(349);
				expr(0);
				}
				break;
			case 2:
				{
				setState(350);
				list();
				}
				break;
			}
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(353);
				match(T__9);
				setState(356);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(354);
					expr(0);
					}
					break;
				case 2:
					{
					setState(355);
					list();
					}
					break;
				}
				}
				}
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(363);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Handle_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Handle_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handle_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterHandle_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitHandle_call(this);
		}
	}

	public final Handle_callContext handle_call() throws RecognitionException {
		Handle_callContext _localctx = new Handle_callContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_handle_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(ID);
			setState(366);
			match(T__3);
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__7) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << BOOL_CONST) | (1L << ID) | (1L << UNARY_OP) | (1L << MINUS) | (1L << STRING_CONST) | (1L << REAL_CONST) | (1L << INT_CONST))) != 0)) {
				{
				setState(367);
				params();
				}
			}

			setState(370);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_params);
		try {
			setState(377);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(373);
				expr(0);
				setState(374);
				match(T__9);
				setState(375);
				params();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<TerminalNode> INT_CONST() { return getTokens(LuluParser.INT_CONST); }
		public TerminalNode INT_CONST(int i) {
			return getToken(LuluParser.INT_CONST, i);
		}
		public Cond_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterCond_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitCond_stmt(this);
		}
	}

	public final Cond_stmtContext cond_stmt() throws RecognitionException {
		Cond_stmtContext _localctx = new Cond_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cond_stmt);
		int _la;
		try {
			setState(403);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				match(T__25);
				setState(380);
				expr(0);
				setState(381);
				block();
				setState(384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__26) {
					{
					setState(382);
					match(T__26);
					setState(383);
					block();
					}
				}

				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(386);
				match(T__27);
				setState(387);
				var();
				setState(388);
				match(T__1);
				setState(395);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__28) {
					{
					{
					setState(389);
					match(T__28);
					setState(390);
					match(INT_CONST);
					setState(391);
					match(T__12);
					setState(392);
					block();
					}
					}
					setState(397);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(398);
				match(T__29);
				setState(399);
				match(T__12);
				setState(400);
				block();
				setState(401);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Loop_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<AssignContext> assign() {
			return getRuleContexts(AssignContext.class);
		}
		public AssignContext assign(int i) {
			return getRuleContext(AssignContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Loop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterLoop_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitLoop_stmt(this);
		}
	}

	public final Loop_stmtContext loop_stmt() throws RecognitionException {
		Loop_stmtContext _localctx = new Loop_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loop_stmt);
		int _la;
		try {
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				match(T__30);
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__18) | (1L << T__19) | (1L << PRIM_TYPE) | (1L << ID))) != 0)) {
					{
					setState(407);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
					case 1:
						{
						setState(406);
						type();
						}
						break;
					}
					setState(409);
					assign();
					}
				}

				setState(412);
				match(T__6);
				setState(413);
				expr(0);
				setState(414);
				match(T__6);
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__18) | (1L << T__19) | (1L << ID))) != 0)) {
					{
					setState(415);
					assign();
					}
				}

				setState(418);
				block();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				match(T__31);
				setState(421);
				expr(0);
				setState(422);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Const_valContext extends ParserRuleContext {
		public TerminalNode INT_CONST() { return getToken(LuluParser.INT_CONST, 0); }
		public TerminalNode REAL_CONST() { return getToken(LuluParser.REAL_CONST, 0); }
		public TerminalNode BOOL_CONST() { return getToken(LuluParser.BOOL_CONST, 0); }
		public TerminalNode STRING_CONST() { return getToken(LuluParser.STRING_CONST, 0); }
		public Const_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterConst_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitConst_val(this);
		}
	}

	public final Const_valContext const_val() throws RecognitionException {
		Const_valContext _localctx = new Const_valContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_const_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL_CONST) | (1L << STRING_CONST) | (1L << REAL_CONST) | (1L << INT_CONST))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode PRIM_TYPE() { return getToken(LuluParser.PRIM_TYPE, 0); }
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			_la = _input.LA(1);
			if ( !(_la==PRIM_TYPE || _la==ID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return args_sempred((ArgsContext)_localctx, predIndex);
		case 4:
			return args_var_sempred((Args_varContext)_localctx, predIndex);
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean args_sempred(ArgsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean args_var_sempred(Args_varContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u01b1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\5\28\n\2\3\2\6\2;\n\2\r\2\16\2<\3\3\3\3\3\3\3"+
		"\3\3\3\6\3D\n\3\r\3\16\3E\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\4\3\4"+
		"\3\4\3\4\5\4U\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5h\n\5\f\5\16\5k\13\5\7\5m\n\5\f\5\16\5p\13\5\3"+
		"\6\3\6\3\6\3\6\7\6v\n\6\f\6\16\6y\13\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6"+
		"\u0082\n\6\f\6\16\6\u0085\13\6\3\6\3\6\7\6\u0089\n\6\f\6\16\6\u008c\13"+
		"\6\3\7\3\7\3\7\3\b\5\b\u0092\n\b\3\b\3\b\3\b\3\b\7\b\u0098\n\b\f\b\16"+
		"\b\u009b\13\b\3\b\3\b\3\t\3\t\3\t\5\t\u00a2\n\t\3\n\3\n\5\n\u00a6\n\n"+
		"\3\13\3\13\3\13\3\13\5\13\u00ac\n\13\3\13\3\13\6\13\u00b0\n\13\r\13\16"+
		"\13\u00b1\3\13\3\13\3\f\5\f\u00b7\n\f\3\f\3\f\5\f\u00bb\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00c2\n\r\3\r\3\r\3\r\3\r\5\r\u00c8\n\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\7\16\u00d0\n\16\f\16\16\16\u00d3\13\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u00e8\n\17\f\17\16\17\u00eb\13\17\3\17\3\17\5\17\u00ef\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\7\20\u00f6\n\20\f\20\16\20\u00f9\13\20\3\20"+
		"\3\20\5\20\u00fd\n\20\3\20\3\20\3\20\3\21\3\21\5\21\u0104\n\21\3\21\3"+
		"\21\3\21\7\21\u0109\n\21\f\21\16\21\u010c\13\21\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u0113\n\22\f\22\16\22\u0116\13\22\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0128\n\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\7\23\u0148\n\23\f\23\16\23\u014b\13\23\3\24\3\24\3\24\5\24"+
		"\u0150\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u015d\n\24\3\25\3\25\3\25\5\25\u0162\n\25\3\25\3\25\3\25\5\25\u0167\n"+
		"\25\7\25\u0169\n\25\f\25\16\25\u016c\13\25\3\25\3\25\3\26\3\26\3\26\5"+
		"\26\u0173\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u017c\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\5\30\u0183\n\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\7\30\u018c\n\30\f\30\16\30\u018f\13\30\3\30\3\30\3\30\3\30\3\30\5\30"+
		"\u0196\n\30\3\31\3\31\5\31\u019a\n\31\3\31\5\31\u019d\n\31\3\31\3\31\3"+
		"\31\3\31\5\31\u01a3\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ab\n\31"+
		"\3\32\3\32\3\33\3\33\3\33\2\5\b\n$\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\5\3\2\25\26\4\2##\62\64\4\2$$&&\2\u01de\2\67"+
		"\3\2\2\2\4>\3\2\2\2\6N\3\2\2\2\bY\3\2\2\2\nq\3\2\2\2\f\u008d\3\2\2\2\16"+
		"\u0091\3\2\2\2\20\u009e\3\2\2\2\22\u00a5\3\2\2\2\24\u00a7\3\2\2\2\26\u00b6"+
		"\3\2\2\2\30\u00c1\3\2\2\2\32\u00cc\3\2\2\2\34\u00ee\3\2\2\2\36\u00fc\3"+
		"\2\2\2 \u0103\3\2\2\2\"\u010d\3\2\2\2$\u0127\3\2\2\2&\u015c\3\2\2\2(\u015e"+
		"\3\2\2\2*\u016f\3\2\2\2,\u017b\3\2\2\2.\u0195\3\2\2\2\60\u01aa\3\2\2\2"+
		"\62\u01ac\3\2\2\2\64\u01ae\3\2\2\2\668\5\4\3\2\67\66\3\2\2\2\678\3\2\2"+
		"\28:\3\2\2\29;\5\22\n\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\3\3\2"+
		"\2\2>?\7\3\2\2?C\7\4\2\2@D\5\6\4\2AD\5\f\7\2BD\5\16\b\2C@\3\2\2\2CA\3"+
		"\2\2\2CB\3\2\2\2DE\3\2\2\2EC\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\5\2\2H\5"+
		"\3\2\2\2IJ\7\6\2\2JK\5\b\5\2KL\7\7\2\2LM\7\b\2\2MO\3\2\2\2NI\3\2\2\2N"+
		"O\3\2\2\2OP\3\2\2\2PQ\7&\2\2QT\7\6\2\2RU\5\b\5\2SU\5\n\6\2TR\3\2\2\2T"+
		"S\3\2\2\2TU\3\2\2\2UV\3\2\2\2VW\7\7\2\2WX\7\t\2\2X\7\3\2\2\2YZ\b\5\1\2"+
		"Z_\5\64\33\2[\\\7\n\2\2\\^\7\13\2\2][\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3"+
		"\2\2\2`n\3\2\2\2a_\3\2\2\2bc\f\3\2\2cd\7\f\2\2di\5\64\33\2ef\7\n\2\2f"+
		"h\7\13\2\2ge\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jm\3\2\2\2ki\3\2\2\2"+
		"lb\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2o\t\3\2\2\2pn\3\2\2\2qr\b\6\1"+
		"\2rw\5\64\33\2st\7\n\2\2tv\7\13\2\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3"+
		"\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7&\2\2{\u008a\3\2\2\2|}\f\3\2\2}~\7\f\2\2"+
		"~\u0083\5\64\33\2\177\u0080\7\n\2\2\u0080\u0082\7\13\2\2\u0081\177\3\2"+
		"\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\u0086\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0087\7&\2\2\u0087\u0089\3\2"+
		"\2\2\u0088|\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\13\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7&\2\2\u008e"+
		"\u008f\7\t\2\2\u008f\r\3\2\2\2\u0090\u0092\7\r\2\2\u0091\u0090\3\2\2\2"+
		"\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\5\64\33\2\u0094\u0099"+
		"\5\20\t\2\u0095\u0096\7\f\2\2\u0096\u0098\5\20\t\2\u0097\u0095\3\2\2\2"+
		"\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c"+
		"\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d\7\t\2\2\u009d\17\3\2\2\2\u009e"+
		"\u00a1\5\"\22\2\u009f\u00a0\7\b\2\2\u00a0\u00a2\5$\23\2\u00a1\u009f\3"+
		"\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\21\3\2\2\2\u00a3\u00a6\5\24\13\2\u00a4"+
		"\u00a6\5\30\r\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\23\3\2\2"+
		"\2\u00a7\u00a8\7\16\2\2\u00a8\u00ab\7&\2\2\u00a9\u00aa\7\17\2\2\u00aa"+
		"\u00ac\7&\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2"+
		"\2\2\u00ad\u00af\7\4\2\2\u00ae\u00b0\5\26\f\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\3\2"+
		"\2\2\u00b3\u00b4\7\5\2\2\u00b4\25\3\2\2\2\u00b5\u00b7\7%\2\2\u00b6\u00b5"+
		"\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00bb\5\16\b\2"+
		"\u00b9\u00bb\5\30\r\2\u00ba\u00b8\3\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\27"+
		"\3\2\2\2\u00bc\u00bd\7\6\2\2\u00bd\u00be\5\n\6\2\u00be\u00bf\7\7\2\2\u00bf"+
		"\u00c0\7\b\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7\20\2\2\u00c4\u00c5\7&\2\2\u00c5"+
		"\u00c7\7\6\2\2\u00c6\u00c8\5\n\6\2\u00c7\u00c6\3\2\2\2\u00c7\u00c8\3\2"+
		"\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7\7\2\2\u00ca\u00cb\5\32\16\2\u00cb"+
		"\31\3\2\2\2\u00cc\u00d1\7\4\2\2\u00cd\u00d0\5\16\b\2\u00ce\u00d0\5\34"+
		"\17\2\u00cf\u00cd\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2"+
		"\2\2\u00d4\u00d5\7\5\2\2\u00d5\33\3\2\2\2\u00d6\u00d7\5\36\20\2\u00d7"+
		"\u00d8\7\t\2\2\u00d8\u00ef\3\2\2\2\u00d9\u00da\5&\24\2\u00da\u00db\7\t"+
		"\2\2\u00db\u00ef\3\2\2\2\u00dc\u00ef\5.\30\2\u00dd\u00ef\5\60\31\2\u00de"+
		"\u00df\7\21\2\2\u00df\u00ef\7\t\2\2\u00e0\u00e1\7\22\2\2\u00e1\u00ef\7"+
		"\t\2\2\u00e2\u00e3\7\23\2\2\u00e3\u00ef\7\t\2\2\u00e4\u00e9\7\24\2\2\u00e5"+
		"\u00e6\7\n\2\2\u00e6\u00e8\7\13\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00eb\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\3\2\2\2\u00eb"+
		"\u00e9\3\2\2\2\u00ec\u00ed\7&\2\2\u00ed\u00ef\7\t\2\2\u00ee\u00d6\3\2"+
		"\2\2\u00ee\u00d9\3\2\2\2\u00ee\u00dc\3\2\2\2\u00ee\u00dd\3\2\2\2\u00ee"+
		"\u00de\3\2\2\2\u00ee\u00e0\3\2\2\2\u00ee\u00e2\3\2\2\2\u00ee\u00e4\3\2"+
		"\2\2\u00ef\35\3\2\2\2\u00f0\u00fd\5 \21\2\u00f1\u00f2\7\6\2\2\u00f2\u00f7"+
		"\5 \21\2\u00f3\u00f4\7\f\2\2\u00f4\u00f6\5 \21\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2"+
		"\2\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\7\7\2\2\u00fb\u00fd\3\2\2\2\u00fc"+
		"\u00f0\3\2\2\2\u00fc\u00f1\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\7\b"+
		"\2\2\u00ff\u0100\5$\23\2\u0100\37\3\2\2\2\u0101\u0102\t\2\2\2\u0102\u0104"+
		"\7\27\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\u0105\3\2\2\2"+
		"\u0105\u010a\5\"\22\2\u0106\u0107\7\27\2\2\u0107\u0109\5\"\22\2\u0108"+
		"\u0106\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b!\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u0114\7&\2\2\u010e\u010f"+
		"\7\n\2\2\u010f\u0110\5$\23\2\u0110\u0111\7\13\2\2\u0111\u0113\3\2\2\2"+
		"\u0112\u010e\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115"+
		"\3\2\2\2\u0115#\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\b\23\1\2\u0118"+
		"\u0119\7\6\2\2\u0119\u011a\5$\23\2\u011a\u011b\7\7\2\2\u011b\u0128\3\2"+
		"\2\2\u011c\u011d\7\'\2\2\u011d\u0128\5$\23\24\u011e\u011f\7(\2\2\u011f"+
		"\u0128\5$\23\23\u0120\u0121\7\30\2\2\u0121\u0128\5*\26\2\u0122\u0128\5"+
		"&\24\2\u0123\u0128\5 \21\2\u0124\u0128\5(\25\2\u0125\u0128\7\31\2\2\u0126"+
		"\u0128\5\62\32\2\u0127\u0117\3\2\2\2\u0127\u011c\3\2\2\2\u0127\u011e\3"+
		"\2\2\2\u0127\u0120\3\2\2\2\u0127\u0122\3\2\2\2\u0127\u0123\3\2\2\2\u0127"+
		"\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128\u0149\3\2"+
		"\2\2\u0129\u012a\f\22\2\2\u012a\u012b\7)\2\2\u012b\u0148\5$\23\23\u012c"+
		"\u012d\f\21\2\2\u012d\u012e\7*\2\2\u012e\u0148\5$\23\22\u012f\u0130\f"+
		"\20\2\2\u0130\u0131\7(\2\2\u0131\u0148\5$\23\21\u0132\u0133\f\17\2\2\u0133"+
		"\u0134\7+\2\2\u0134\u0148\5$\23\20\u0135\u0136\f\16\2\2\u0136\u0137\7"+
		"-\2\2\u0137\u0148\5$\23\17\u0138\u0139\f\r\2\2\u0139\u013a\7,\2\2\u013a"+
		"\u0148\5$\23\16\u013b\u013c\f\f\2\2\u013c\u013d\7\60\2\2\u013d\u0148\5"+
		"$\23\r\u013e\u013f\f\13\2\2\u013f\u0140\7\61\2\2\u0140\u0148\5$\23\f\u0141"+
		"\u0142\f\n\2\2\u0142\u0143\7.\2\2\u0143\u0148\5$\23\13\u0144\u0145\f\t"+
		"\2\2\u0145\u0146\7/\2\2\u0146\u0148\5$\23\n\u0147\u0129\3\2\2\2\u0147"+
		"\u012c\3\2\2\2\u0147\u012f\3\2\2\2\u0147\u0132\3\2\2\2\u0147\u0135\3\2"+
		"\2\2\u0147\u0138\3\2\2\2\u0147\u013b\3\2\2\2\u0147\u013e\3\2\2\2\u0147"+
		"\u0141\3\2\2\2\u0147\u0144\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u0149\u014a\3\2\2\2\u014a%\3\2\2\2\u014b\u0149\3\2\2\2\u014c\u014d"+
		"\5 \21\2\u014d\u014e\7\27\2\2\u014e\u0150\3\2\2\2\u014f\u014c\3\2\2\2"+
		"\u014f\u0150\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u015d\5*\26\2\u0152\u0153"+
		"\7\32\2\2\u0153\u0154\7\6\2\2\u0154\u0155\5 \21\2\u0155\u0156\7\7\2\2"+
		"\u0156\u015d\3\2\2\2\u0157\u0158\7\33\2\2\u0158\u0159\7\6\2\2\u0159\u015a"+
		"\5 \21\2\u015a\u015b\7\7\2\2\u015b\u015d\3\2\2\2\u015c\u014f\3\2\2\2\u015c"+
		"\u0152\3\2\2\2\u015c\u0157\3\2\2\2\u015d\'\3\2\2\2\u015e\u0161\7\n\2\2"+
		"\u015f\u0162\5$\23\2\u0160\u0162\5(\25\2\u0161\u015f\3\2\2\2\u0161\u0160"+
		"\3\2\2\2\u0162\u016a\3\2\2\2\u0163\u0166\7\f\2\2\u0164\u0167\5$\23\2\u0165"+
		"\u0167\5(\25\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167\u0169\3\2"+
		"\2\2\u0168\u0163\3\2\2\2\u0169\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016a"+
		"\u016b\3\2\2\2\u016b\u016d\3\2\2\2\u016c\u016a\3\2\2\2\u016d\u016e\7\13"+
		"\2\2\u016e)\3\2\2\2\u016f\u0170\7&\2\2\u0170\u0172\7\6\2\2\u0171\u0173"+
		"\5,\27\2\u0172\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0175\7\7\2\2\u0175+\3\2\2\2\u0176\u017c\5$\23\2\u0177\u0178\5$\23\2"+
		"\u0178\u0179\7\f\2\2\u0179\u017a\5,\27\2\u017a\u017c\3\2\2\2\u017b\u0176"+
		"\3\2\2\2\u017b\u0177\3\2\2\2\u017c-\3\2\2\2\u017d\u017e\7\34\2\2\u017e"+
		"\u017f\5$\23\2\u017f\u0182\5\32\16\2\u0180\u0181\7\35\2\2\u0181\u0183"+
		"\5\32\16\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0196\3\2\2\2"+
		"\u0184\u0185\7\36\2\2\u0185\u0186\5 \21\2\u0186\u018d\7\4\2\2\u0187\u0188"+
		"\7\37\2\2\u0188\u0189\7\64\2\2\u0189\u018a\7\17\2\2\u018a\u018c\5\32\16"+
		"\2\u018b\u0187\3\2\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018d\u018e"+
		"\3\2\2\2\u018e\u0190\3\2\2\2\u018f\u018d\3\2\2\2\u0190\u0191\7 \2\2\u0191"+
		"\u0192\7\17\2\2\u0192\u0193\5\32\16\2\u0193\u0194\7\5\2\2\u0194\u0196"+
		"\3\2\2\2\u0195\u017d\3\2\2\2\u0195\u0184\3\2\2\2\u0196/\3\2\2\2\u0197"+
		"\u019c\7!\2\2\u0198\u019a\5\64\33\2\u0199\u0198\3\2\2\2\u0199\u019a\3"+
		"\2\2\2\u019a\u019b\3\2\2\2\u019b\u019d\5\36\20\2\u019c\u0199\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\u019e\3\2\2\2\u019e\u019f\7\t\2\2\u019f\u01a0\5$"+
		"\23\2\u01a0\u01a2\7\t\2\2\u01a1\u01a3\5\36\20\2\u01a2\u01a1\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a5\5\32\16\2\u01a5\u01ab\3"+
		"\2\2\2\u01a6\u01a7\7\"\2\2\u01a7\u01a8\5$\23\2\u01a8\u01a9\5\32\16\2\u01a9"+
		"\u01ab\3\2\2\2\u01aa\u0197\3\2\2\2\u01aa\u01a6\3\2\2\2\u01ab\61\3\2\2"+
		"\2\u01ac\u01ad\t\3\2\2\u01ad\63\3\2\2\2\u01ae\u01af\t\4\2\2\u01af\65\3"+
		"\2\2\2\62\67<CENT_inw\u0083\u008a\u0091\u0099\u00a1\u00a5\u00ab\u00b1"+
		"\u00b6\u00ba\u00c1\u00c7\u00cf\u00d1\u00e9\u00ee\u00f7\u00fc\u0103\u010a"+
		"\u0114\u0127\u0147\u0149\u014f\u015c\u0161\u0166\u016a\u0172\u017b\u0182"+
		"\u018d\u0195\u0199\u019c\u01a2\u01aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}