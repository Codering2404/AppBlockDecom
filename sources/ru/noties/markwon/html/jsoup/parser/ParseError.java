package ru.noties.markwon.html.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ParseError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f147234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f147235b;

    ParseError(int i3, String str) {
        this.f147234a = i3;
        this.f147235b = str;
    }

    public String toString() {
        return this.f147234a + ": " + this.f147235b;
    }

    ParseError(int i3, String str, Object... objArr) {
        this.f147235b = String.format(str, objArr);
        this.f147234a = i3;
    }
}
