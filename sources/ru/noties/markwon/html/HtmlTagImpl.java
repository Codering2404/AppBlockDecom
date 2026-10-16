package ru.noties.markwon.html;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.noties.markwon.html.HtmlTag;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class HtmlTagImpl implements HtmlTag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f147192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f147193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map f147194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f147195d = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InlineImpl extends HtmlTagImpl implements HtmlTag.Inline {
        InlineImpl(String str, int i3, Map map) {
            super(str, i3, map);
        }

        @Override // ru.noties.markwon.html.HtmlTag
        public HtmlTag.Block a() {
            throw new ClassCastException("Cannot cast Inline instance to Block");
        }

        @Override // ru.noties.markwon.html.HtmlTag
        public boolean b() {
            return false;
        }

        void g(int i3) {
            if (isClosed()) {
                return;
            }
            this.f147195d = i3;
        }

        public String toString() {
            return "InlineImpl{name='" + this.f147192a + "', start=" + this.f147193b + ", end=" + this.f147195d + ", attributes=" + this.f147194c + '}';
        }
    }

    protected HtmlTagImpl(String str, int i3, Map map) {
        this.f147192a = str;
        this.f147193b = i3;
        this.f147194c = map;
    }

    @Override // ru.noties.markwon.html.HtmlTag
    public Map c() {
        return this.f147194c;
    }

    @Override // ru.noties.markwon.html.HtmlTag
    public int end() {
        return this.f147195d;
    }

    public boolean f() {
        return this.f147193b == this.f147195d;
    }

    @Override // ru.noties.markwon.html.HtmlTag
    public boolean isClosed() {
        return this.f147195d > -1;
    }

    @Override // ru.noties.markwon.html.HtmlTag
    public String name() {
        return this.f147192a;
    }

    @Override // ru.noties.markwon.html.HtmlTag
    public int start() {
        return this.f147193b;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class BlockImpl extends HtmlTagImpl implements HtmlTag.Block {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final BlockImpl f147196e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        List f147197f;

        BlockImpl(String str, int i3, Map map, BlockImpl blockImpl) {
            super(str, i3, map);
            this.f147196e = blockImpl;
        }

        static BlockImpl h(String str, int i3, Map map, BlockImpl blockImpl) {
            return new BlockImpl(str, i3, map, blockImpl);
        }

        static BlockImpl i() {
            return new BlockImpl("", 0, Collections.EMPTY_MAP, null);
        }

        @Override // ru.noties.markwon.html.HtmlTag
        public boolean b() {
            return true;
        }

        @Override // ru.noties.markwon.html.HtmlTagImpl, ru.noties.markwon.html.HtmlTag
        public Map c() {
            return this.f147194c;
        }

        @Override // ru.noties.markwon.html.HtmlTag.Block
        public HtmlTag.Block d() {
            return this.f147196e;
        }

        @Override // ru.noties.markwon.html.HtmlTag.Block
        public List e() {
            List list = this.f147197f;
            return list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
        }

        void g(int i3) {
            if (isClosed()) {
                return;
            }
            this.f147195d = i3;
            List list = this.f147197f;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((BlockImpl) it.next()).g(i3);
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("BlockImpl{name='");
            sb.append(this.f147192a);
            sb.append('\'');
            sb.append(", start=");
            sb.append(this.f147193b);
            sb.append(", end=");
            sb.append(this.f147195d);
            sb.append(", attributes=");
            sb.append(this.f147194c);
            sb.append(", parent=");
            BlockImpl blockImpl = this.f147196e;
            sb.append(blockImpl != null ? blockImpl.f147192a : null);
            sb.append(", children=");
            sb.append(this.f147197f);
            sb.append('}');
            return sb.toString();
        }

        @Override // ru.noties.markwon.html.HtmlTag
        public HtmlTag.Block a() {
            return this;
        }
    }
}
