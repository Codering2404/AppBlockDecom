package ru.noties.markwon.image.data;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class DataUri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f147381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f147382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f147383c;

    public DataUri(String str, boolean z2, String str2) {
        this.f147381a = str;
        this.f147382b = z2;
        this.f147383c = str2;
    }

    public boolean a() {
        return this.f147382b;
    }

    public String b() {
        return this.f147381a;
    }

    public String c() {
        return this.f147383c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            DataUri dataUri = (DataUri) obj;
            if (this.f147382b != dataUri.f147382b) {
                return false;
            }
            String str = this.f147381a;
            if (str == null ? dataUri.f147381a != null : !str.equals(dataUri.f147381a)) {
                return false;
            }
            String str2 = this.f147383c;
            String str3 = dataUri.f147383c;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f147381a;
        int iHashCode = (((str != null ? str.hashCode() : 0) * 31) + (this.f147382b ? 1 : 0)) * 31;
        String str2 = this.f147383c;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DataUri{contentType='" + this.f147381a + "', base64=" + this.f147382b + ", data='" + this.f147383c + "'}";
    }
}
