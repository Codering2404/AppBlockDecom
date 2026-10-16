package ru.noties.markwon.html.jsoup.nodes;

import java.util.Arrays;
import java.util.Iterator;
import ru.noties.markwon.html.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Attributes implements Iterable<Attribute>, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f147219d = new String[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f147220a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String[] f147221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f147222c;

    public Attributes() {
        String[] strArr = f147219d;
        this.f147221b = strArr;
        this.f147222c = strArr;
    }

    private void e(String str, String str2) {
        g(this.f147220a + 1);
        String[] strArr = this.f147221b;
        int i3 = this.f147220a;
        strArr[i3] = str;
        this.f147222c[i3] = str2;
        this.f147220a = i3 + 1;
    }

    private void g(int i3) {
        Validate.d(i3 >= this.f147220a);
        String[] strArr = this.f147221b;
        int length = strArr.length;
        if (length >= i3) {
            return;
        }
        int i4 = length >= 4 ? this.f147220a * 2 : 4;
        if (i3 <= i4) {
            i3 = i4;
        }
        this.f147221b = p(strArr, i3);
        this.f147222c = p(this.f147222c, i3);
    }

    static String h(String str) {
        return str == null ? "" : str;
    }

    private static String[] p(String[] strArr, int i3) {
        String[] strArr2 = new String[i3];
        System.arraycopy(strArr, 0, strArr2, 0, Math.min(strArr.length, i3));
        return strArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(int i3) {
        Validate.b(i3 >= this.f147220a);
        int i4 = (this.f147220a - i3) - 1;
        if (i4 > 0) {
            String[] strArr = this.f147221b;
            int i5 = i3 + 1;
            System.arraycopy(strArr, i5, strArr, i3, i4);
            String[] strArr2 = this.f147222c;
            System.arraycopy(strArr2, i5, strArr2, i3, i4);
        }
        int i6 = this.f147220a - 1;
        this.f147220a = i6;
        this.f147221b[i6] = null;
        this.f147222c[i6] = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attributes attributes = (Attributes) obj;
        if (this.f147220a == attributes.f147220a && Arrays.equals(this.f147221b, attributes.f147221b)) {
            return Arrays.equals(this.f147222c, attributes.f147222c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f147220a * 31) + Arrays.hashCode(this.f147221b)) * 31) + Arrays.hashCode(this.f147222c);
    }

    @Override // java.lang.Iterable
    public Iterator<Attribute> iterator() {
        return new Iterator<Attribute>() { // from class: ru.noties.markwon.html.jsoup.nodes.Attributes.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f147223a = 0;

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Attribute next() {
                Attributes attributes = Attributes.this;
                String[] strArr = attributes.f147222c;
                int i3 = this.f147223a;
                String str = strArr[i3];
                String str2 = attributes.f147221b[i3];
                if (str == null) {
                    str = "";
                }
                Attribute attribute = new Attribute(str2, str, attributes);
                this.f147223a++;
                return attribute;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f147223a < Attributes.this.f147220a;
            }

            @Override // java.util.Iterator
            public void remove() {
                Attributes attributes = Attributes.this;
                int i3 = this.f147223a - 1;
                this.f147223a = i3;
                attributes.u(i3);
            }
        };
    }

    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Attributes clone() {
        try {
            Attributes attributes = (Attributes) super.clone();
            attributes.f147220a = this.f147220a;
            this.f147221b = p(this.f147221b, this.f147220a);
            this.f147222c = p(this.f147222c, this.f147220a);
            return attributes;
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    public String q(String str) {
        int iS = s(str);
        return iS == -1 ? "" : h(this.f147222c[iS]);
    }

    int s(String str) {
        Validate.f(str);
        for (int i3 = 0; i3 < this.f147220a; i3++) {
            if (str.equals(this.f147221b[i3])) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f147220a;
    }

    public Attributes t(String str, String str2) {
        int iS = s(str);
        if (iS != -1) {
            this.f147222c[iS] = str2;
            return this;
        }
        e(str, str2);
        return this;
    }
}
