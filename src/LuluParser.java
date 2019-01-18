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
		T__31=32, T__32=33, BOOL_CONST=34, PRIM_TYPE=35, ACCSSMOD=36, ID=37, UNARY_OP=38, 
		MINUS=39, ARIT_P1=40, ARIT_P2=41, BITWISE_AND=42, BITWISE_OR=43, BITWISE_XOR=44, 
		LOGICAL_AND=45, LOGICAL_OR=46, REL=47, REL_EQ=48, STRING_CONST=49, REAL_CONST=50, 
		INT_CONST=51, WHITESPACE=52, LINE_COMMENT=53, COMMENT=54;
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
		null, "'declare'", "'{'", "'}'", "'('", "')'", "'='", "'native'", "';'", 
		"'['", "']'", "','", "'const'", "'type'", "':'", "'function'", "'return'", 
		"'break'", "'continue'", "'destruct'", "'this'", "'super'", "'.'", "'allocate'", 
		"'nil'", "'read'", "'write'", "'if'", "'else'", "'switch'", "'case'", 
		"'default'", "'for'", "'while'", null, null, null, null, null, "'-'", 
		null, "'+'", "'&'", "'|'", "'^'", "'&&'", "'||'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "BOOL_CONST", 
		"PRIM_TYPE", "ACCSSMOD", "ID", "UNARY_OP", "MINUS", "ARIT_P1", "ARIT_P2", 
		"BITWISE_AND", "BITWISE_OR", "BITWISE_XOR", "LOGICAL_AND", "LOGICAL_OR", 
		"REL", "REL_EQ", "STRING_CONST", "REAL_CONST", "INT_CONST", "WHITESPACE", 
		"LINE_COMMENT", "COMMENT"
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__12) | (1L << T__14))) != 0) );
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__6) | (1L << T__11) | (1L << PRIM_TYPE) | (1L << ID))) != 0) );
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

			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(78);
				match(T__6);
				}
			}

			setState(81);
			match(ID);
			setState(82);
			match(T__3);
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(83);
				args(0);
				}
				break;
			case 2:
				{
				setState(84);
				args_var(0);
				}
				break;
			}
			setState(87);
			match(T__4);
			setState(88);
			match(T__7);
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
			setState(91);
			type();
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					match(T__8);
					setState(93);
					match(T__9);
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgsContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_args);
					setState(99);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(100);
					match(T__10);
					setState(101);
					type();
					setState(106);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(102);
							match(T__8);
							setState(103);
							match(T__9);
							}
							} 
						}
						setState(108);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					}
					}
					} 
				}
				setState(113);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
			setState(115);
			type();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(116);
				match(T__8);
				setState(117);
				match(T__9);
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(139);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Args_varContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_args_var);
					setState(125);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(126);
					match(T__10);
					setState(127);
					type();
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(128);
						match(T__8);
						setState(129);
						match(T__9);
						}
						}
						setState(134);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(135);
					match(ID);
					}
					} 
				}
				setState(141);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
			setState(142);
			match(ID);
			setState(143);
			match(T__7);
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
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(145);
				match(T__11);
				}
			}

			setState(148);
			type();
			setState(149);
			var_val();
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(150);
				match(T__10);
				setState(151);
				var_val();
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(157);
			match(T__7);
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
			setState(159);
			ref();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(160);
				match(T__5);
				setState(161);
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
		public Ft_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ft_def; }
	 
		public Ft_defContext() { }
		public void copyFrom(Ft_defContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FUNCContext extends Ft_defContext {
		public Func_defContext func_def() {
			return getRuleContext(Func_defContext.class,0);
		}
		public FUNCContext(Ft_defContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFUNC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFUNC(this);
		}
	}
	public static class TYPEContext extends Ft_defContext {
		public Type_defContext type_def() {
			return getRuleContext(Type_defContext.class,0);
		}
		public TYPEContext(Ft_defContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterTYPE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitTYPE(this);
		}
	}

	public final Ft_defContext ft_def() throws RecognitionException {
		Ft_defContext _localctx = new Ft_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ft_def);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				_localctx = new TYPEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				type_def();
				}
				break;
			case T__3:
			case T__14:
				_localctx = new FUNCContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
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
			setState(168);
			match(T__12);
			setState(169);
			match(ID);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(170);
				match(T__13);
				setState(171);
				match(ID);
				}
			}

			setState(174);
			match(T__1);
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175);
				component();
				}
				}
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__14) | (1L << PRIM_TYPE) | (1L << ACCSSMOD) | (1L << ID))) != 0) );
			setState(180);
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
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCSSMOD) {
				{
				setState(182);
				match(ACCSSMOD);
				}
			}

			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case PRIM_TYPE:
			case ID:
				{
				setState(185);
				var_def();
				}
				break;
			case T__3:
			case T__14:
				{
				setState(186);
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
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(189);
				match(T__3);
				setState(190);
				args_var(0);
				setState(191);
				match(T__4);
				setState(192);
				match(T__5);
				}
			}

			setState(196);
			match(T__14);
			setState(197);
			match(ID);
			setState(198);
			match(T__3);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PRIM_TYPE || _la==ID) {
				{
				setState(199);
				args_var(0);
				}
			}

			setState(202);
			match(T__4);
			setState(203);
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
			setState(205);
			match(T__1);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__28) | (1L << T__31) | (1L << T__32) | (1L << PRIM_TYPE) | (1L << ID))) != 0)) {
				{
				setState(208);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(206);
					var_def();
					}
					break;
				case 2:
					{
					setState(207);
					stmt();
					}
					break;
				}
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
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
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CONTINUEContext extends StmtContext {
		public CONTINUEContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterCONTINUE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitCONTINUE(this);
		}
	}
	public static class RETURNContext extends StmtContext {
		public RETURNContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterRETURN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitRETURN(this);
		}
	}
	public static class DESTRUCTIONContext extends StmtContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public DESTRUCTIONContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterDESTRUCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitDESTRUCTION(this);
		}
	}
	public static class LOOPContext extends StmtContext {
		public Loop_stmtContext loop_stmt() {
			return getRuleContext(Loop_stmtContext.class,0);
		}
		public LOOPContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterLOOP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitLOOP(this);
		}
	}
	public static class BREAKContext extends StmtContext {
		public BREAKContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBREAK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBREAK(this);
		}
	}
	public static class CONDITIONContext extends StmtContext {
		public Cond_stmtContext cond_stmt() {
			return getRuleContext(Cond_stmtContext.class,0);
		}
		public CONDITIONContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterCONDITION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitCONDITION(this);
		}
	}
	public static class ASSIGNContext extends StmtContext {
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public ASSIGNContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterASSIGN(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitASSIGN(this);
		}
	}
	public static class FUNCTIONCContext extends StmtContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public FUNCTIONCContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFUNCTIONC(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFUNCTIONC(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		int _la;
		try {
			setState(239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new ASSIGNContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				assign();
				setState(216);
				match(T__7);
				}
				break;
			case 2:
				_localctx = new FUNCTIONCContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				func_call();
				setState(219);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new CONDITIONContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(221);
				cond_stmt();
				}
				break;
			case 4:
				_localctx = new LOOPContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(222);
				loop_stmt();
				}
				break;
			case 5:
				_localctx = new RETURNContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(223);
				match(T__15);
				setState(224);
				match(T__7);
				}
				break;
			case 6:
				_localctx = new BREAKContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(225);
				match(T__16);
				setState(226);
				match(T__7);
				}
				break;
			case 7:
				_localctx = new CONTINUEContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(227);
				match(T__17);
				setState(228);
				match(T__7);
				}
				break;
			case 8:
				_localctx = new DESTRUCTIONContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(229);
				match(T__18);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(230);
					match(T__8);
					setState(231);
					match(T__9);
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				match(ID);
				setState(238);
				match(T__7);
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
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
			case ID:
				{
				setState(241);
				var();
				}
				break;
			case T__3:
				{
				setState(242);
				match(T__3);
				setState(243);
				var();
				setState(248);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(244);
					match(T__10);
					setState(245);
					var();
					}
					}
					setState(250);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(251);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(255);
			match(T__5);
			setState(256);
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
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19 || _la==T__20) {
				{
				setState(258);
				_la = _input.LA(1);
				if ( !(_la==T__19 || _la==T__20) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(259);
				match(T__21);
				}
			}

			setState(262);
			ref();
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(263);
					match(T__21);
					setState(264);
					ref();
					}
					} 
				}
				setState(269);
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
			setState(270);
			match(ID);
			setState(277);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(271);
					match(T__8);
					setState(272);
					expr(0);
					setState(273);
					match(T__9);
					}
					} 
				}
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VARContext extends ExprContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VARContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterVAR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitVAR(this);
		}
	}
	public static class BITWISE_ORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BITWISE_OR() { return getToken(LuluParser.BITWISE_OR, 0); }
		public BITWISE_ORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBITWISE_OR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBITWISE_OR(this);
		}
	}
	public static class LOGICAL_ANDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGICAL_AND() { return getToken(LuluParser.LOGICAL_AND, 0); }
		public LOGICAL_ANDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterLOGICAL_AND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitLOGICAL_AND(this);
		}
	}
	public static class ARIT_P1Context extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARIT_P1() { return getToken(LuluParser.ARIT_P1, 0); }
		public ARIT_P1Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterARIT_P1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitARIT_P1(this);
		}
	}
	public static class BITWISE_ANDContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BITWISE_AND() { return getToken(LuluParser.BITWISE_AND, 0); }
		public BITWISE_ANDContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBITWISE_AND(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBITWISE_AND(this);
		}
	}
	public static class ARIT_P2Context extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode ARIT_P2() { return getToken(LuluParser.ARIT_P2, 0); }
		public ARIT_P2Context(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterARIT_P2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitARIT_P2(this);
		}
	}
	public static class LOGICAL_ORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGICAL_OR() { return getToken(LuluParser.LOGICAL_OR, 0); }
		public LOGICAL_ORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterLOGICAL_OR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitLOGICAL_OR(this);
		}
	}
	public static class ALLOCATIONContext extends ExprContext {
		public Handle_callContext handle_call() {
			return getRuleContext(Handle_callContext.class,0);
		}
		public ALLOCATIONContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterALLOCATION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitALLOCATION(this);
		}
	}
	public static class FUNCTIONContext extends ExprContext {
		public Func_callContext func_call() {
			return getRuleContext(Func_callContext.class,0);
		}
		public FUNCTIONContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFUNCTION(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFUNCTION(this);
		}
	}
	public static class BITWISE_XORContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BITWISE_XOR() { return getToken(LuluParser.BITWISE_XOR, 0); }
		public BITWISE_XORContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBITWISE_XOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBITWISE_XOR(this);
		}
	}
	public static class MINUSContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(LuluParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MINUSContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterMINUS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitMINUS(this);
		}
	}
	public static class REL_EQContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode REL_EQ() { return getToken(LuluParser.REL_EQ, 0); }
		public REL_EQContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterREL_EQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitREL_EQ(this);
		}
	}
	public static class NILContext extends ExprContext {
		public NILContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterNIL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitNIL(this);
		}
	}
	public static class UNARY_OPContext extends ExprContext {
		public TerminalNode UNARY_OP() { return getToken(LuluParser.UNARY_OP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UNARY_OPContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterUNARY_OP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitUNARY_OP(this);
		}
	}
	public static class PARENTHESESContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PARENTHESESContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterPARENTHESES(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitPARENTHESES(this);
		}
	}
	public static class CONSTContext extends ExprContext {
		public Const_valContext const_val() {
			return getRuleContext(Const_valContext.class,0);
		}
		public CONSTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterCONST(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitCONST(this);
		}
	}
	public static class RELContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode REL() { return getToken(LuluParser.REL, 0); }
		public RELContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterREL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitREL(this);
		}
	}
	public static class LISTContext extends ExprContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public LISTContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterLIST(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitLIST(this);
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
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new PARENTHESESContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(281);
				match(T__3);
				setState(282);
				expr(0);
				setState(283);
				match(T__4);
				}
				break;
			case 2:
				{
				_localctx = new UNARY_OPContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(UNARY_OP);
				setState(286);
				expr(18);
				}
				break;
			case 3:
				{
				_localctx = new MINUSContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				match(MINUS);
				setState(288);
				expr(17);
				}
				break;
			case 4:
				{
				_localctx = new ALLOCATIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(T__22);
				setState(290);
				handle_call();
				}
				break;
			case 5:
				{
				_localctx = new FUNCTIONContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				func_call();
				}
				break;
			case 6:
				{
				_localctx = new VARContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				var();
				}
				break;
			case 7:
				{
				_localctx = new LISTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(293);
				list();
				}
				break;
			case 8:
				{
				_localctx = new NILContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				match(T__23);
				}
				break;
			case 9:
				{
				_localctx = new CONSTContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(295);
				const_val();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(328);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new ARIT_P1Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(299);
						match(ARIT_P1);
						setState(300);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ARIT_P2Context(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(302);
						match(ARIT_P2);
						setState(303);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new MINUSContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(304);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(305);
						match(MINUS);
						setState(306);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new BITWISE_ANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(307);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(308);
						match(BITWISE_AND);
						setState(309);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new BITWISE_XORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(311);
						match(BITWISE_XOR);
						setState(312);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new BITWISE_ORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(314);
						match(BITWISE_OR);
						setState(315);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new RELContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(317);
						match(REL);
						setState(318);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new REL_EQContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(320);
						match(REL_EQ);
						setState(321);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new LOGICAL_ANDContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(323);
						match(LOGICAL_AND);
						setState(324);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new LOGICAL_ORContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(326);
						match(LOGICAL_OR);
						setState(327);
						expr(8);
						}
						break;
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		public Func_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_call; }
	 
		public Func_callContext() { }
		public void copyFrom(Func_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class READContext extends Func_callContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public READContext(Func_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterREAD(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitREAD(this);
		}
	}
	public static class HANDLEContext extends Func_callContext {
		public Handle_callContext handle_call() {
			return getRuleContext(Handle_callContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public HANDLEContext(Func_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterHANDLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitHANDLE(this);
		}
	}
	public static class WRITEContext extends Func_callContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public WRITEContext(Func_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterWRITE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitWRITE(this);
		}
	}

	public final Func_callContext func_call() throws RecognitionException {
		Func_callContext _localctx = new Func_callContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_func_call);
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
			case T__20:
			case ID:
				_localctx = new HANDLEContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(336);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(333);
					var();
					setState(334);
					match(T__21);
					}
					break;
				}
				setState(338);
				handle_call();
				}
				break;
			case T__24:
				_localctx = new READContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(T__24);
				setState(340);
				match(T__3);
				setState(341);
				var();
				setState(342);
				match(T__4);
				}
				break;
			case T__25:
				_localctx = new WRITEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(344);
				match(T__25);
				setState(345);
				match(T__3);
				setState(346);
				var();
				setState(347);
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
			setState(351);
			match(T__8);
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(352);
				expr(0);
				}
				break;
			case 2:
				{
				setState(353);
				list();
				}
				break;
			}
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(356);
				match(T__10);
				setState(359);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
				case 1:
					{
					setState(357);
					expr(0);
					}
					break;
				case 2:
					{
					setState(358);
					list();
					}
					break;
				}
				}
				}
				setState(365);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(366);
			match(T__9);
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
			setState(368);
			match(ID);
			setState(369);
			match(T__3);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__8) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << BOOL_CONST) | (1L << ID) | (1L << UNARY_OP) | (1L << MINUS) | (1L << STRING_CONST) | (1L << REAL_CONST) | (1L << INT_CONST))) != 0)) {
				{
				setState(370);
				params();
				}
			}

			setState(373);
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
			setState(380);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				expr(0);
				setState(377);
				match(T__10);
				setState(378);
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
		public Cond_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_stmt; }
	 
		public Cond_stmtContext() { }
		public void copyFrom(Cond_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IFContext extends Cond_stmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IFContext(Cond_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitIF(this);
		}
	}
	public static class CASEContext extends Cond_stmtContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<TerminalNode> INT_CONST() { return getTokens(LuluParser.INT_CONST); }
		public TerminalNode INT_CONST(int i) {
			return getToken(LuluParser.INT_CONST, i);
		}
		public CASEContext(Cond_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterCASE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitCASE(this);
		}
	}

	public final Cond_stmtContext cond_stmt() throws RecognitionException {
		Cond_stmtContext _localctx = new Cond_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cond_stmt);
		int _la;
		try {
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				_localctx = new IFContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(382);
				match(T__26);
				setState(383);
				expr(0);
				setState(384);
				block();
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__27) {
					{
					setState(385);
					match(T__27);
					setState(386);
					block();
					}
				}

				}
				break;
			case T__28:
				_localctx = new CASEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(389);
				match(T__28);
				setState(390);
				var();
				setState(391);
				match(T__1);
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__29) {
					{
					{
					setState(392);
					match(T__29);
					setState(393);
					match(INT_CONST);
					setState(394);
					match(T__13);
					setState(395);
					block();
					}
					}
					setState(400);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(401);
				match(T__30);
				setState(402);
				match(T__13);
				setState(403);
				block();
				setState(404);
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
		public Loop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_stmt; }
	 
		public Loop_stmtContext() { }
		public void copyFrom(Loop_stmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FORContext extends Loop_stmtContext {
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
		public FORContext(Loop_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterFOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitFOR(this);
		}
	}
	public static class WHILEContext extends Loop_stmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WHILEContext(Loop_stmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterWHILE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitWHILE(this);
		}
	}

	public final Loop_stmtContext loop_stmt() throws RecognitionException {
		Loop_stmtContext _localctx = new Loop_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_loop_stmt);
		int _la;
		try {
			setState(427);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__31:
				_localctx = new FORContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(408);
				match(T__31);
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__19) | (1L << T__20) | (1L << PRIM_TYPE) | (1L << ID))) != 0)) {
					{
					setState(410);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
					case 1:
						{
						setState(409);
						type();
						}
						break;
					}
					setState(412);
					assign();
					}
				}

				setState(415);
				match(T__7);
				setState(416);
				expr(0);
				setState(417);
				match(T__7);
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__19) | (1L << T__20) | (1L << ID))) != 0)) {
					{
					setState(418);
					assign();
					}
				}

				setState(421);
				block();
				}
				break;
			case T__32:
				_localctx = new WHILEContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(T__32);
				setState(424);
				expr(0);
				setState(425);
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
		public Const_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_val; }
	 
		public Const_valContext() { }
		public void copyFrom(Const_valContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BOOLContext extends Const_valContext {
		public TerminalNode BOOL_CONST() { return getToken(LuluParser.BOOL_CONST, 0); }
		public BOOLContext(Const_valContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterBOOL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitBOOL(this);
		}
	}
	public static class REALContext extends Const_valContext {
		public TerminalNode REAL_CONST() { return getToken(LuluParser.REAL_CONST, 0); }
		public REALContext(Const_valContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterREAL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitREAL(this);
		}
	}
	public static class STRINGContext extends Const_valContext {
		public TerminalNode STRING_CONST() { return getToken(LuluParser.STRING_CONST, 0); }
		public STRINGContext(Const_valContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterSTRING(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitSTRING(this);
		}
	}
	public static class INTContext extends Const_valContext {
		public TerminalNode INT_CONST() { return getToken(LuluParser.INT_CONST, 0); }
		public INTContext(Const_valContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterINT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitINT(this);
		}
	}

	public final Const_valContext const_val() throws RecognitionException {
		Const_valContext _localctx = new Const_valContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_const_val);
		try {
			setState(433);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_CONST:
				_localctx = new INTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				match(INT_CONST);
				}
				break;
			case REAL_CONST:
				_localctx = new REALContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(430);
				match(REAL_CONST);
				}
				break;
			case BOOL_CONST:
				_localctx = new BOOLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(431);
				match(BOOL_CONST);
				}
				break;
			case STRING_CONST:
				_localctx = new STRINGContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(432);
				match(STRING_CONST);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PRIMContext extends TypeContext {
		public TerminalNode PRIM_TYPE() { return getToken(LuluParser.PRIM_TYPE, 0); }
		public PRIMContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterPRIM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitPRIM(this);
		}
	}
	public static class IDContext extends TypeContext {
		public TerminalNode ID() { return getToken(LuluParser.ID, 0); }
		public IDContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).enterID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LuluListener ) ((LuluListener)listener).exitID(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_type);
		try {
			setState(437);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIM_TYPE:
				_localctx = new PRIMContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				match(PRIM_TYPE);
				}
				break;
			case ID:
				_localctx = new IDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				match(ID);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u01ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\5\28\n\2\3\2\6\2;\n\2\r\2\16\2<\3\3\3\3\3\3\3"+
		"\3\3\3\6\3D\n\3\r\3\16\3E\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4O\n\4\3\4\5\4"+
		"R\n\4\3\4\3\4\3\4\3\4\5\4X\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5a\n\5\f"+
		"\5\16\5d\13\5\3\5\3\5\3\5\3\5\3\5\7\5k\n\5\f\5\16\5n\13\5\7\5p\n\5\f\5"+
		"\16\5s\13\5\3\6\3\6\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\7\6\u0085\n\6\f\6\16\6\u0088\13\6\3\6\3\6\7\6\u008c\n\6\f\6"+
		"\16\6\u008f\13\6\3\7\3\7\3\7\3\b\5\b\u0095\n\b\3\b\3\b\3\b\3\b\7\b\u009b"+
		"\n\b\f\b\16\b\u009e\13\b\3\b\3\b\3\t\3\t\3\t\5\t\u00a5\n\t\3\n\3\n\5\n"+
		"\u00a9\n\n\3\13\3\13\3\13\3\13\5\13\u00af\n\13\3\13\3\13\6\13\u00b3\n"+
		"\13\r\13\16\13\u00b4\3\13\3\13\3\f\5\f\u00ba\n\f\3\f\3\f\5\f\u00be\n\f"+
		"\3\r\3\r\3\r\3\r\3\r\5\r\u00c5\n\r\3\r\3\r\3\r\3\r\5\r\u00cb\n\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\7\16\u00d3\n\16\f\16\16\16\u00d6\13\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\7\17\u00eb\n\17\f\17\16\17\u00ee\13\17\3\17\3\17\5\17"+
		"\u00f2\n\17\3\20\3\20\3\20\3\20\3\20\7\20\u00f9\n\20\f\20\16\20\u00fc"+
		"\13\20\3\20\3\20\5\20\u0100\n\20\3\20\3\20\3\20\3\21\3\21\5\21\u0107\n"+
		"\21\3\21\3\21\3\21\7\21\u010c\n\21\f\21\16\21\u010f\13\21\3\22\3\22\3"+
		"\22\3\22\3\22\7\22\u0116\n\22\f\22\16\22\u0119\13\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u012b"+
		"\n\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u014b\n\23\f\23\16\23\u014e\13\23\3\24\3\24\3\24"+
		"\5\24\u0153\n\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u0160\n\24\3\25\3\25\3\25\5\25\u0165\n\25\3\25\3\25\3\25\5\25\u016a"+
		"\n\25\7\25\u016c\n\25\f\25\16\25\u016f\13\25\3\25\3\25\3\26\3\26\3\26"+
		"\5\26\u0176\n\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\5\27\u017f\n\27\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u0186\n\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u018f\n\30\f\30\16\30\u0192\13\30\3\30\3\30\3\30\3\30\3\30"+
		"\5\30\u0199\n\30\3\31\3\31\5\31\u019d\n\31\3\31\5\31\u01a0\n\31\3\31\3"+
		"\31\3\31\3\31\5\31\u01a6\n\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u01ae"+
		"\n\31\3\32\3\32\3\32\3\32\5\32\u01b4\n\32\3\33\3\33\5\33\u01b8\n\33\3"+
		"\33\2\5\b\n$\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\2\3\3\2\26\27\2\u01ec\2\67\3\2\2\2\4>\3\2\2\2\6N\3\2\2\2\b\\\3\2\2"+
		"\2\nt\3\2\2\2\f\u0090\3\2\2\2\16\u0094\3\2\2\2\20\u00a1\3\2\2\2\22\u00a8"+
		"\3\2\2\2\24\u00aa\3\2\2\2\26\u00b9\3\2\2\2\30\u00c4\3\2\2\2\32\u00cf\3"+
		"\2\2\2\34\u00f1\3\2\2\2\36\u00ff\3\2\2\2 \u0106\3\2\2\2\"\u0110\3\2\2"+
		"\2$\u012a\3\2\2\2&\u015f\3\2\2\2(\u0161\3\2\2\2*\u0172\3\2\2\2,\u017e"+
		"\3\2\2\2.\u0198\3\2\2\2\60\u01ad\3\2\2\2\62\u01b3\3\2\2\2\64\u01b7\3\2"+
		"\2\2\668\5\4\3\2\67\66\3\2\2\2\678\3\2\2\28:\3\2\2\29;\5\22\n\2:9\3\2"+
		"\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\3\3\2\2\2>?\7\3\2\2?C\7\4\2\2@D\5"+
		"\6\4\2AD\5\f\7\2BD\5\16\b\2C@\3\2\2\2CA\3\2\2\2CB\3\2\2\2DE\3\2\2\2EC"+
		"\3\2\2\2EF\3\2\2\2FG\3\2\2\2GH\7\5\2\2H\5\3\2\2\2IJ\7\6\2\2JK\5\b\5\2"+
		"KL\7\7\2\2LM\7\b\2\2MO\3\2\2\2NI\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PR\7\t\2\2"+
		"QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\'\2\2TW\7\6\2\2UX\5\b\5\2VX\5\n\6\2"+
		"WU\3\2\2\2WV\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\7\7\2\2Z[\7\n\2\2[\7\3\2\2"+
		"\2\\]\b\5\1\2]b\5\64\33\2^_\7\13\2\2_a\7\f\2\2`^\3\2\2\2ad\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2cq\3\2\2\2db\3\2\2\2ef\f\3\2\2fg\7\r\2\2gl\5\64\33\2h"+
		"i\7\13\2\2ik\7\f\2\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2\2mp\3\2\2\2"+
		"nl\3\2\2\2oe\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\t\3\2\2\2sq\3\2\2"+
		"\2tu\b\6\1\2uz\5\64\33\2vw\7\13\2\2wy\7\f\2\2xv\3\2\2\2y|\3\2\2\2zx\3"+
		"\2\2\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\'\2\2~\u008d\3\2\2\2\177\u0080"+
		"\f\3\2\2\u0080\u0081\7\r\2\2\u0081\u0086\5\64\33\2\u0082\u0083\7\13\2"+
		"\2\u0083\u0085\7\f\2\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008a\7\'\2\2\u008a\u008c\3\2\2\2\u008b\177\3\2\2\2\u008c\u008f\3\2\2"+
		"\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\13\3\2\2\2\u008f\u008d"+
		"\3\2\2\2\u0090\u0091\7\'\2\2\u0091\u0092\7\n\2\2\u0092\r\3\2\2\2\u0093"+
		"\u0095\7\16\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3"+
		"\2\2\2\u0096\u0097\5\64\33\2\u0097\u009c\5\20\t\2\u0098\u0099\7\r\2\2"+
		"\u0099\u009b\5\20\t\2\u009a\u0098\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f"+
		"\u00a0\7\n\2\2\u00a0\17\3\2\2\2\u00a1\u00a4\5\"\22\2\u00a2\u00a3\7\b\2"+
		"\2\u00a3\u00a5\5$\23\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\21"+
		"\3\2\2\2\u00a6\u00a9\5\24\13\2\u00a7\u00a9\5\30\r\2\u00a8\u00a6\3\2\2"+
		"\2\u00a8\u00a7\3\2\2\2\u00a9\23\3\2\2\2\u00aa\u00ab\7\17\2\2\u00ab\u00ae"+
		"\7\'\2\2\u00ac\u00ad\7\20\2\2\u00ad\u00af\7\'\2\2\u00ae\u00ac\3\2\2\2"+
		"\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b2\7\4\2\2\u00b1\u00b3"+
		"\5\26\f\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2"+
		"\u00b4\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7\25"+
		"\3\2\2\2\u00b8\u00ba\7&\2\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00be\5\16\b\2\u00bc\u00be\5\30\r\2\u00bd\u00bb\3"+
		"\2\2\2\u00bd\u00bc\3\2\2\2\u00be\27\3\2\2\2\u00bf\u00c0\7\6\2\2\u00c0"+
		"\u00c1\5\n\6\2\u00c1\u00c2\7\7\2\2\u00c2\u00c3\7\b\2\2\u00c3\u00c5\3\2"+
		"\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c7\7\21\2\2\u00c7\u00c8\7\'\2\2\u00c8\u00ca\7\6\2\2\u00c9\u00cb\5"+
		"\n\6\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cc"+
		"\u00cd\7\7\2\2\u00cd\u00ce\5\32\16\2\u00ce\31\3\2\2\2\u00cf\u00d4\7\4"+
		"\2\2\u00d0\u00d3\5\16\b\2\u00d1\u00d3\5\34\17\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2"+
		"\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\5\2\2\u00d8"+
		"\33\3\2\2\2\u00d9\u00da\5\36\20\2\u00da\u00db\7\n\2\2\u00db\u00f2\3\2"+
		"\2\2\u00dc\u00dd\5&\24\2\u00dd\u00de\7\n\2\2\u00de\u00f2\3\2\2\2\u00df"+
		"\u00f2\5.\30\2\u00e0\u00f2\5\60\31\2\u00e1\u00e2\7\22\2\2\u00e2\u00f2"+
		"\7\n\2\2\u00e3\u00e4\7\23\2\2\u00e4\u00f2\7\n\2\2\u00e5\u00e6\7\24\2\2"+
		"\u00e6\u00f2\7\n\2\2\u00e7\u00ec\7\25\2\2\u00e8\u00e9\7\13\2\2\u00e9\u00eb"+
		"\7\f\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec"+
		"\u00ed\3\2\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7\'"+
		"\2\2\u00f0\u00f2\7\n\2\2\u00f1\u00d9\3\2\2\2\u00f1\u00dc\3\2\2\2\u00f1"+
		"\u00df\3\2\2\2\u00f1\u00e0\3\2\2\2\u00f1\u00e1\3\2\2\2\u00f1\u00e3\3\2"+
		"\2\2\u00f1\u00e5\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f2\35\3\2\2\2\u00f3\u0100"+
		"\5 \21\2\u00f4\u00f5\7\6\2\2\u00f5\u00fa\5 \21\2\u00f6\u00f7\7\r\2\2\u00f7"+
		"\u00f9\5 \21\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2"+
		"\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd"+
		"\u00fe\7\7\2\2\u00fe\u0100\3\2\2\2\u00ff\u00f3\3\2\2\2\u00ff\u00f4\3\2"+
		"\2\2\u0100\u0101\3\2\2\2\u0101\u0102\7\b\2\2\u0102\u0103\5$\23\2\u0103"+
		"\37\3\2\2\2\u0104\u0105\t\2\2\2\u0105\u0107\7\30\2\2\u0106\u0104\3\2\2"+
		"\2\u0106\u0107\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010d\5\"\22\2\u0109"+
		"\u010a\7\30\2\2\u010a\u010c\5\"\22\2\u010b\u0109\3\2\2\2\u010c\u010f\3"+
		"\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e!\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u0110\u0117\7\'\2\2\u0111\u0112\7\13\2\2\u0112\u0113\5$\23\2"+
		"\u0113\u0114\7\f\2\2\u0114\u0116\3\2\2\2\u0115\u0111\3\2\2\2\u0116\u0119"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118#\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u011b\b\23\1\2\u011b\u011c\7\6\2\2\u011c\u011d\5"+
		"$\23\2\u011d\u011e\7\7\2\2\u011e\u012b\3\2\2\2\u011f\u0120\7(\2\2\u0120"+
		"\u012b\5$\23\24\u0121\u0122\7)\2\2\u0122\u012b\5$\23\23\u0123\u0124\7"+
		"\31\2\2\u0124\u012b\5*\26\2\u0125\u012b\5&\24\2\u0126\u012b\5 \21\2\u0127"+
		"\u012b\5(\25\2\u0128\u012b\7\32\2\2\u0129\u012b\5\62\32\2\u012a\u011a"+
		"\3\2\2\2\u012a\u011f\3\2\2\2\u012a\u0121\3\2\2\2\u012a\u0123\3\2\2\2\u012a"+
		"\u0125\3\2\2\2\u012a\u0126\3\2\2\2\u012a\u0127\3\2\2\2\u012a\u0128\3\2"+
		"\2\2\u012a\u0129\3\2\2\2\u012b\u014c\3\2\2\2\u012c\u012d\f\22\2\2\u012d"+
		"\u012e\7*\2\2\u012e\u014b\5$\23\23\u012f\u0130\f\21\2\2\u0130\u0131\7"+
		"+\2\2\u0131\u014b\5$\23\22\u0132\u0133\f\20\2\2\u0133\u0134\7)\2\2\u0134"+
		"\u014b\5$\23\21\u0135\u0136\f\17\2\2\u0136\u0137\7,\2\2\u0137\u014b\5"+
		"$\23\20\u0138\u0139\f\16\2\2\u0139\u013a\7.\2\2\u013a\u014b\5$\23\17\u013b"+
		"\u013c\f\r\2\2\u013c\u013d\7-\2\2\u013d\u014b\5$\23\16\u013e\u013f\f\f"+
		"\2\2\u013f\u0140\7\61\2\2\u0140\u014b\5$\23\r\u0141\u0142\f\13\2\2\u0142"+
		"\u0143\7\62\2\2\u0143\u014b\5$\23\f\u0144\u0145\f\n\2\2\u0145\u0146\7"+
		"/\2\2\u0146\u014b\5$\23\13\u0147\u0148\f\t\2\2\u0148\u0149\7\60\2\2\u0149"+
		"\u014b\5$\23\n\u014a\u012c\3\2\2\2\u014a\u012f\3\2\2\2\u014a\u0132\3\2"+
		"\2\2\u014a\u0135\3\2\2\2\u014a\u0138\3\2\2\2\u014a\u013b\3\2\2\2\u014a"+
		"\u013e\3\2\2\2\u014a\u0141\3\2\2\2\u014a\u0144\3\2\2\2\u014a\u0147\3\2"+
		"\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"%\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\5 \21\2\u0150\u0151\7\30\2\2"+
		"\u0151\u0153\3\2\2\2\u0152\u014f\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154"+
		"\3\2\2\2\u0154\u0160\5*\26\2\u0155\u0156\7\33\2\2\u0156\u0157\7\6\2\2"+
		"\u0157\u0158\5 \21\2\u0158\u0159\7\7\2\2\u0159\u0160\3\2\2\2\u015a\u015b"+
		"\7\34\2\2\u015b\u015c\7\6\2\2\u015c\u015d\5 \21\2\u015d\u015e\7\7\2\2"+
		"\u015e\u0160\3\2\2\2\u015f\u0152\3\2\2\2\u015f\u0155\3\2\2\2\u015f\u015a"+
		"\3\2\2\2\u0160\'\3\2\2\2\u0161\u0164\7\13\2\2\u0162\u0165\5$\23\2\u0163"+
		"\u0165\5(\25\2\u0164\u0162\3\2\2\2\u0164\u0163\3\2\2\2\u0165\u016d\3\2"+
		"\2\2\u0166\u0169\7\r\2\2\u0167\u016a\5$\23\2\u0168\u016a\5(\25\2\u0169"+
		"\u0167\3\2\2\2\u0169\u0168\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0166\3\2"+
		"\2\2\u016c\u016f\3\2\2\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u0170\3\2\2\2\u016f\u016d\3\2\2\2\u0170\u0171\7\f\2\2\u0171)\3\2\2\2"+
		"\u0172\u0173\7\'\2\2\u0173\u0175\7\6\2\2\u0174\u0176\5,\27\2\u0175\u0174"+
		"\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7\7\2\2\u0178"+
		"+\3\2\2\2\u0179\u017f\5$\23\2\u017a\u017b\5$\23\2\u017b\u017c\7\r\2\2"+
		"\u017c\u017d\5,\27\2\u017d\u017f\3\2\2\2\u017e\u0179\3\2\2\2\u017e\u017a"+
		"\3\2\2\2\u017f-\3\2\2\2\u0180\u0181\7\35\2\2\u0181\u0182\5$\23\2\u0182"+
		"\u0185\5\32\16\2\u0183\u0184\7\36\2\2\u0184\u0186\5\32\16\2\u0185\u0183"+
		"\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0199\3\2\2\2\u0187\u0188\7\37\2\2"+
		"\u0188\u0189\5 \21\2\u0189\u0190\7\4\2\2\u018a\u018b\7 \2\2\u018b\u018c"+
		"\7\65\2\2\u018c\u018d\7\20\2\2\u018d\u018f\5\32\16\2\u018e\u018a\3\2\2"+
		"\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193"+
		"\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0194\7!\2\2\u0194\u0195\7\20\2\2\u0195"+
		"\u0196\5\32\16\2\u0196\u0197\7\5\2\2\u0197\u0199\3\2\2\2\u0198\u0180\3"+
		"\2\2\2\u0198\u0187\3\2\2\2\u0199/\3\2\2\2\u019a\u019f\7\"\2\2\u019b\u019d"+
		"\5\64\33\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019e\3\2\2\2"+
		"\u019e\u01a0\5\36\20\2\u019f\u019c\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1"+
		"\3\2\2\2\u01a1\u01a2\7\n\2\2\u01a2\u01a3\5$\23\2\u01a3\u01a5\7\n\2\2\u01a4"+
		"\u01a6\5\36\20\2\u01a5\u01a4\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\3"+
		"\2\2\2\u01a7\u01a8\5\32\16\2\u01a8\u01ae\3\2\2\2\u01a9\u01aa\7#\2\2\u01aa"+
		"\u01ab\5$\23\2\u01ab\u01ac\5\32\16\2\u01ac\u01ae\3\2\2\2\u01ad\u019a\3"+
		"\2\2\2\u01ad\u01a9\3\2\2\2\u01ae\61\3\2\2\2\u01af\u01b4\7\65\2\2\u01b0"+
		"\u01b4\7\64\2\2\u01b1\u01b4\7$\2\2\u01b2\u01b4\7\63\2\2\u01b3\u01af\3"+
		"\2\2\2\u01b3\u01b0\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4"+
		"\63\3\2\2\2\u01b5\u01b8\7%\2\2\u01b6\u01b8\7\'\2\2\u01b7\u01b5\3\2\2\2"+
		"\u01b7\u01b6\3\2\2\2\u01b8\65\3\2\2\2\65\67<CENQWblqz\u0086\u008d\u0094"+
		"\u009c\u00a4\u00a8\u00ae\u00b4\u00b9\u00bd\u00c4\u00ca\u00d2\u00d4\u00ec"+
		"\u00f1\u00fa\u00ff\u0106\u010d\u0117\u012a\u014a\u014c\u0152\u015f\u0164"+
		"\u0169\u016d\u0175\u017e\u0185\u0190\u0198\u019c\u019f\u01a5\u01ad\u01b3"+
		"\u01b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}