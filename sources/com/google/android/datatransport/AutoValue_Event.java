package com.google.android.datatransport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_Event<T> extends Event<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f69047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f69048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Priority f69049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ProductData f69050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final EventContext f69051e;

    AutoValue_Event(Integer num, Object obj, Priority priority, ProductData productData, EventContext eventContext) {
        this.f69047a = num;
        if (obj == null) {
            throw new NullPointerException("Null payload");
        }
        this.f69048b = obj;
        if (priority == null) {
            throw new NullPointerException("Null priority");
        }
        this.f69049c = priority;
        this.f69050d = productData;
        this.f69051e = eventContext;
    }

    @Override // com.google.android.datatransport.Event
    public Integer a() {
        return this.f69047a;
    }

    @Override // com.google.android.datatransport.Event
    public EventContext b() {
        return this.f69051e;
    }

    @Override // com.google.android.datatransport.Event
    public Object c() {
        return this.f69048b;
    }

    @Override // com.google.android.datatransport.Event
    public Priority d() {
        return this.f69049c;
    }

    @Override // com.google.android.datatransport.Event
    public ProductData e() {
        return this.f69050d;
    }

    public boolean equals(Object obj) {
        ProductData productData;
        EventContext eventContext;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Event) {
            Event event = (Event) obj;
            Integer num = this.f69047a;
            if (num != null ? num.equals(event.a()) : event.a() == null) {
                if (this.f69048b.equals(event.c()) && this.f69049c.equals(event.d()) && ((productData = this.f69050d) != null ? productData.equals(event.e()) : event.e() == null) && ((eventContext = this.f69051e) != null ? eventContext.equals(event.b()) : event.b() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f69047a;
        int iHashCode = ((((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f69048b.hashCode()) * 1000003) ^ this.f69049c.hashCode()) * 1000003;
        ProductData productData = this.f69050d;
        int iHashCode2 = (iHashCode ^ (productData == null ? 0 : productData.hashCode())) * 1000003;
        EventContext eventContext = this.f69051e;
        return iHashCode2 ^ (eventContext != null ? eventContext.hashCode() : 0);
    }

    public String toString() {
        return "Event{code=" + this.f69047a + ", payload=" + this.f69048b + ", priority=" + this.f69049c + ", productData=" + this.f69050d + ", eventContext=" + this.f69051e + "}";
    }
}
