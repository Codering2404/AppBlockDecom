package ru.noties.markwon.html;

import com.facebook.AuthenticationToken;
import com.facebook.AuthenticationTokenClaims;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import ru.noties.markwon.html.HtmlTagImpl;
import ru.noties.markwon.html.MarkwonHtmlParser;
import ru.noties.markwon.html.jsoup.nodes.Attribute;
import ru.noties.markwon.html.jsoup.nodes.Attributes;
import ru.noties.markwon.html.jsoup.parser.CharacterReader;
import ru.noties.markwon.html.jsoup.parser.ParseErrorList;
import ru.noties.markwon.html.jsoup.parser.Token;
import ru.noties.markwon.html.jsoup.parser.Tokeniser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MarkwonHtmlParserImpl extends MarkwonHtmlParser {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Set f147198g = Collections.unmodifiableSet(new HashSet(Arrays.asList("a", "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", UserDataStore.EMAIL, "i", "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", "small", "span", "strong", AuthenticationTokenClaims.JSON_KEY_SUB, "sup", "textarea", "time", "tt", "var")));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Set f147199h = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", "param", "source", "track", "wbr")));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Set f147200i = Collections.unmodifiableSet(new HashSet(Arrays.asList(IntegrityManager.INTEGRITY_TYPE_ADDRESS, "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", AuthenticationToken.HEADER_KEY, "hgroup", "hr", "li", "main", "nav", "noscript", "ol", "output", "p", "pre", "section", "table", "tfoot", "ul", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HtmlEmptyTagReplacement f147201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TrimmingAppender f147202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f147203c = new ArrayList(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HtmlTagImpl.BlockImpl f147204d = HtmlTagImpl.BlockImpl.i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f147205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f147206f;

    /* JADX INFO: renamed from: ru.noties.markwon.html.MarkwonHtmlParserImpl$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f147207a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f147207a = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f147207a[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f147207a[Token.TokenType.Character.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    MarkwonHtmlParserImpl(HtmlEmptyTagReplacement htmlEmptyTagReplacement, TrimmingAppender trimmingAppender) {
        this.f147201a = htmlEmptyTagReplacement;
        this.f147202b = trimmingAppender;
    }

    public static MarkwonHtmlParserImpl h() {
        return i(HtmlEmptyTagReplacement.a());
    }

    public static MarkwonHtmlParserImpl i(HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        return new MarkwonHtmlParserImpl(htmlEmptyTagReplacement, TrimmingAppender.b());
    }

    protected static void j(Appendable appendable) {
        CharSequence charSequence = (CharSequence) appendable;
        int length = charSequence.length();
        if (length <= 0 || '\n' == charSequence.charAt(length - 1)) {
            return;
        }
        AppendableUtils.a(appendable, '\n');
    }

    protected static Map l(Token.StartTag startTag) {
        Attributes attributes = startTag.f147254j;
        int size = attributes.size();
        if (size <= 0) {
            return Collections.EMPTY_MAP;
        }
        HashMap map = new HashMap(size);
        for (Attribute attribute : attributes) {
            map.put(attribute.getKey().toLowerCase(Locale.US), attribute.getValue());
        }
        return Collections.unmodifiableMap(map);
    }

    protected static boolean o(String str) {
        return f147200i.contains(str);
    }

    protected static boolean p(Appendable appendable, HtmlTagImpl htmlTagImpl) {
        return htmlTagImpl.f147193b == ((CharSequence) appendable).length();
    }

    protected static boolean q(String str) {
        return f147198g.contains(str);
    }

    protected static boolean r(String str) {
        return f147199h.contains(str);
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void a(int i3, MarkwonHtmlParser.FlushAction flushAction) {
        HtmlTagImpl.BlockImpl blockImpl = this.f147204d;
        while (true) {
            HtmlTagImpl.BlockImpl blockImpl2 = blockImpl.f147196e;
            if (blockImpl2 == null) {
                break;
            } else {
                blockImpl = blockImpl2;
            }
        }
        if (i3 > -1) {
            blockImpl.g(i3);
        }
        List listE = blockImpl.e();
        if (listE.size() > 0) {
            flushAction.a(listE);
        } else {
            flushAction.a(Collections.EMPTY_LIST);
        }
        this.f147204d = HtmlTagImpl.BlockImpl.i();
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void b(int i3, MarkwonHtmlParser.FlushAction flushAction) {
        if (this.f147203c.size() <= 0) {
            flushAction.a(Collections.EMPTY_LIST);
            return;
        }
        if (i3 > -1) {
            Iterator it = this.f147203c.iterator();
            while (it.hasNext()) {
                ((HtmlTagImpl.InlineImpl) it.next()).g(i3);
            }
        }
        flushAction.a(Collections.unmodifiableList(this.f147203c));
        this.f147203c.clear();
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void d(Appendable appendable, String str) {
        Tokeniser tokeniser = new Tokeniser(new CharacterReader(str), ParseErrorList.b());
        while (true) {
            Token tokenT = tokeniser.t();
            Token.TokenType tokenType = tokenT.f147237a;
            if (Token.TokenType.EOF == tokenType) {
                return;
            }
            int i3 = AnonymousClass1.f147207a[tokenType.ordinal()];
            if (i3 == 1) {
                Token.StartTag startTag = (Token.StartTag) tokenT;
                if (q(startTag.f147247c)) {
                    w(appendable, startTag);
                } else {
                    t(appendable, startTag);
                }
            } else if (i3 == 2) {
                Token.EndTag endTag = (Token.EndTag) tokenT;
                if (q(endTag.f147247c)) {
                    v(appendable, endTag);
                } else {
                    s(appendable, endTag);
                }
            } else if (i3 == 3) {
                u(appendable, (Token.Character) tokenT);
            }
            tokenT.a();
        }
    }

    @Override // ru.noties.markwon.html.MarkwonHtmlParser
    public void e() {
        this.f147203c.clear();
        this.f147204d = HtmlTagImpl.BlockImpl.i();
    }

    protected void f(HtmlTagImpl.BlockImpl blockImpl, HtmlTagImpl.BlockImpl blockImpl2) {
        List arrayList = blockImpl.f147197f;
        if (arrayList == null) {
            arrayList = new ArrayList(2);
            blockImpl.f147197f = arrayList;
        }
        arrayList.add(blockImpl2);
    }

    protected void g(Appendable appendable, HtmlTagImpl htmlTagImpl) {
        String strB = this.f147201a.b(htmlTagImpl);
        if (strB != null) {
            AppendableUtils.b(appendable, strB);
        }
    }

    protected void k(Appendable appendable) {
        if (this.f147206f) {
            j(appendable);
            this.f147206f = false;
        }
    }

    protected HtmlTagImpl.BlockImpl m(String str) {
        HtmlTagImpl.BlockImpl blockImpl = this.f147204d;
        while (blockImpl != null && !str.equals(blockImpl.f147192a) && !blockImpl.isClosed()) {
            blockImpl = blockImpl.f147196e;
        }
        return blockImpl;
    }

    protected HtmlTagImpl.InlineImpl n(String str) {
        int size = this.f147203c.size();
        while (true) {
            size--;
            if (size <= -1) {
                return null;
            }
            HtmlTagImpl.InlineImpl inlineImpl = (HtmlTagImpl.InlineImpl) this.f147203c.get(size);
            if (str.equals(inlineImpl.f147192a) && inlineImpl.f147195d < 0) {
                return inlineImpl;
            }
        }
    }

    protected void s(Appendable appendable, Token.EndTag endTag) {
        String str = endTag.f147247c;
        HtmlTagImpl.BlockImpl blockImplM = m(str);
        if (blockImplM != null) {
            if ("pre".equals(str)) {
                this.f147205e = false;
            }
            if (p(appendable, blockImplM)) {
                g(appendable, blockImplM);
            }
            blockImplM.g(((CharSequence) appendable).length());
            if (!blockImplM.f()) {
                this.f147206f = o(blockImplM.f147192a);
            }
            if ("p".equals(str)) {
                AppendableUtils.a(appendable, '\n');
            }
            this.f147204d = blockImplM.f147196e;
        }
    }

    protected void t(Appendable appendable, Token.StartTag startTag) {
        String str = startTag.f147247c;
        if ("p".equals(this.f147204d.f147192a)) {
            this.f147204d.g(((CharSequence) appendable).length());
            AppendableUtils.a(appendable, '\n');
            this.f147204d = this.f147204d.f147196e;
        } else if ("li".equals(str) && "li".equals(this.f147204d.f147192a)) {
            this.f147204d.g(((CharSequence) appendable).length());
            this.f147204d = this.f147204d.f147196e;
        }
        if (o(str)) {
            this.f147205e = "pre".equals(str);
            j(appendable);
        } else {
            k(appendable);
        }
        CharSequence charSequence = (CharSequence) appendable;
        HtmlTagImpl.BlockImpl blockImplH = HtmlTagImpl.BlockImpl.h(str, charSequence.length(), l(startTag), this.f147204d);
        boolean z2 = r(str) || startTag.f147253i;
        if (z2) {
            String strB = this.f147201a.b(blockImplH);
            if (strB != null && strB.length() > 0) {
                AppendableUtils.b(appendable, strB);
            }
            blockImplH.g(charSequence.length());
        }
        f(blockImplH.f147196e, blockImplH);
        if (z2) {
            return;
        }
        this.f147204d = blockImplH;
    }

    protected void u(Appendable appendable, Token.Character character) {
        if (this.f147205e) {
            AppendableUtils.b(appendable, character.d());
        } else {
            k(appendable);
            this.f147202b.a(appendable, character.d());
        }
    }

    protected void v(Appendable appendable, Token.EndTag endTag) {
        HtmlTagImpl.InlineImpl inlineImplN = n(endTag.f147247c);
        if (inlineImplN != null) {
            if (p(appendable, inlineImplN)) {
                g(appendable, inlineImplN);
            }
            inlineImplN.g(((CharSequence) appendable).length());
        }
    }

    protected void w(Appendable appendable, Token.StartTag startTag) {
        String str = startTag.f147247c;
        CharSequence charSequence = (CharSequence) appendable;
        HtmlTagImpl.InlineImpl inlineImpl = new HtmlTagImpl.InlineImpl(str, charSequence.length(), l(startTag));
        k(appendable);
        if (r(str) || startTag.f147253i) {
            String strB = this.f147201a.b(inlineImpl);
            if (strB != null && strB.length() > 0) {
                AppendableUtils.b(appendable, strB);
            }
            inlineImpl.g(charSequence.length());
        }
        this.f147203c.add(inlineImpl);
    }
}
