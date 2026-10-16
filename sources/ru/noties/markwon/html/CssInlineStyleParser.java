package ru.noties.markwon.html;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class CssInlineStyleParser {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl extends CssInlineStyleParser {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class CssIterable implements Iterable<CssProperty> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f147182a;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            private class CssIterator implements Iterator<CssProperty> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final CssProperty f147183a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final StringBuilder f147184b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final int f147185c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                private int f147186d;

                private CssIterator() {
                    this.f147183a = new CssProperty();
                    this.f147184b = new StringBuilder();
                    this.f147185c = CssIterable.this.f147182a.length();
                }

                private boolean a() {
                    return b(this.f147183a.a(), this.f147183a.c());
                }

                private boolean b(String str, String str2) {
                    return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
                }

                private void d() {
                    this.f147183a.b("", "");
                    this.f147184b.setLength(0);
                    String strTrim = null;
                    boolean z2 = false;
                    String strTrim2 = null;
                    for (int i3 = this.f147186d; i3 < this.f147185c; i3++) {
                        char cCharAt = CssIterable.this.f147182a.charAt(i3);
                        if (strTrim == null) {
                            if (':' == cCharAt) {
                                if (this.f147184b.length() > 0) {
                                    strTrim = this.f147184b.toString().trim();
                                }
                                this.f147184b.setLength(0);
                            } else if (';' == cCharAt) {
                                this.f147184b.setLength(0);
                            } else if (Character.isWhitespace(cCharAt)) {
                                if (this.f147184b.length() > 0) {
                                    z2 = true;
                                }
                            } else if (z2) {
                                this.f147184b.setLength(0);
                                this.f147184b.append(cCharAt);
                                z2 = false;
                            } else {
                                this.f147184b.append(cCharAt);
                            }
                        } else if (strTrim2 != null) {
                            continue;
                        } else if (Character.isWhitespace(cCharAt)) {
                            if (this.f147184b.length() > 0) {
                                this.f147184b.append(cCharAt);
                            }
                        } else if (';' == cCharAt) {
                            strTrim2 = this.f147184b.toString().trim();
                            this.f147184b.setLength(0);
                            if (b(strTrim, strTrim2)) {
                                this.f147186d = i3 + 1;
                                this.f147183a.b(strTrim, strTrim2);
                                return;
                            }
                        } else {
                            this.f147184b.append(cCharAt);
                        }
                    }
                    if (strTrim == null || this.f147184b.length() <= 0) {
                        return;
                    }
                    this.f147183a.b(strTrim, this.f147184b.toString().trim());
                    this.f147186d = this.f147185c;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public CssProperty next() {
                    if (a()) {
                        return this.f147183a;
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    d();
                    return a();
                }
            }

            CssIterable(String str) {
                this.f147182a = str;
            }

            @Override // java.lang.Iterable
            public Iterator<CssProperty> iterator() {
                return new CssIterator();
            }
        }

        Impl() {
        }

        @Override // ru.noties.markwon.html.CssInlineStyleParser
        public Iterable b(String str) {
            return new CssIterable(str);
        }
    }

    public static CssInlineStyleParser a() {
        return new Impl();
    }

    public abstract Iterable b(String str);
}
