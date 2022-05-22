package dev.kkkkkksssssaaaa.spay.user;

import dev.kkkkkksssssaaaa.spay.user.privacy.Privacy;

public class User {

    private final Privacy privacy;

    private User(Privacy privacy) {
        this.privacy = privacy;
    }

    public static User fromPrivacy(Privacy privacy) {
        return new User(privacy);
    }

    @Override
    public boolean equals(Object o) {
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }

        return ((User) o).privacy.equals(this.privacy);
    }

    @Override
    public int hashCode() {
        return this.privacy.hashCode();
    }

}
