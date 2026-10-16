package ru.noties.markwon.html;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CssProperty {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f147188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f147189b;

    CssProperty() {
    }

    public String a() {
        return this.f147188a;
    }

    void b(String str, String str2) {
        this.f147188a = str;
        this.f147189b = str2;
    }

    public String c() {
        return this.f147189b;
    }

    public String toString() {
        return "CssProperty{key='" + this.f147188a + "', value='" + this.f147189b + "'}";
    }
}
