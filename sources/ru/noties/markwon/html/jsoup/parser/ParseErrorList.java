package ru.noties.markwon.html.jsoup.parser;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class ParseErrorList extends ArrayList<ParseError> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f147236a;

    ParseErrorList(int i3, int i4) {
        super(i3);
        this.f147236a = i4;
    }

    public static ParseErrorList b() {
        return new ParseErrorList(0, 0);
    }

    boolean a() {
        return size() < this.f147236a;
    }
}
