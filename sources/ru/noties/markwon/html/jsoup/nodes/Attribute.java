package ru.noties.markwon.html.jsoup.nodes;

import java.util.Map;
import ru.noties.markwon.html.jsoup.helper.Validate;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Attribute implements Map.Entry<String, String>, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f147216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f147217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Attributes f147218c;

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.f(str);
        this.f147216a = str.trim();
        Validate.e(str);
        this.f147217b = str2;
        this.f147218c = attributes;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e3) {
            throw new RuntimeException(e3);
        }
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getKey() {
        return this.f147216a;
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return this.f147217b;
    }

    @Override // java.util.Map.Entry
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public String setValue(String str) {
        int iS;
        String strQ = this.f147218c.q(this.f147216a);
        Attributes attributes = this.f147218c;
        if (attributes != null && (iS = attributes.s(this.f147216a)) != -1) {
            this.f147218c.f147222c[iS] = str;
        }
        this.f147217b = str;
        return strQ;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Attribute attribute = (Attribute) obj;
            String str = this.f147216a;
            if (str == null ? attribute.f147216a != null : !str.equals(attribute.f147216a)) {
                return false;
            }
            String str2 = this.f147217b;
            String str3 = attribute.f147217b;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        String str = this.f147216a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f147217b;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }
}
