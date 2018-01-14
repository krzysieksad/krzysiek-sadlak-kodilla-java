package com.kodilla.testing.library;

public class LibraryUser {
    private final String firstName;
    private final String lastName;
    private final String peselId;

    /**
     * User of library.
     * @param firstName firstName.
     * @param lastName lastName.
     * @param peselId pesel.
     */
    public LibraryUser(final String firstName, final String lastName, final String peselId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.peselId = peselId;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPeselId() {
        return peselId;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", peselId='" + peselId + '\'' +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LibraryUser)) {
            return false;
        }
        LibraryUser that = (LibraryUser) o;
        if (!firstName.equals(that.firstName)) {
            return false;
        }
        if (!lastName.equals(that.lastName)) {
            return false;
        }
        return peselId.equals(that.peselId);
    }

    @Override
    public int hashCode() {
        int result = firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + peselId.hashCode();
        return result;
    }
}
