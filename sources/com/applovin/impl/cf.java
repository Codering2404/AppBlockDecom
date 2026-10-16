package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface cf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cf f58903a = new a();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements cf {
        a() {
        }

        @Override // com.applovin.impl.cf
        public boolean a(e9 e9Var) {
            String str = e9Var.f59394m;
            return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // com.applovin.impl.cf
        public bf b(e9 e9Var) {
            String str = e9Var.f59394m;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new a1();
                    case "application/x-icy":
                        return new ta();
                    case "application/id3":
                        return new wa();
                    case "application/x-emsg":
                        return new w7();
                    case "application/x-scte35":
                        return new tk();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(e9 e9Var);

    bf b(e9 e9Var);
}
