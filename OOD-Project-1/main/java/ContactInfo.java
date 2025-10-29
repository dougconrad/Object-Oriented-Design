import java.util.Objects;

public class ContactInfo {

  private Name name;
  private String address;
  private String phoneNumber;
  private String emailAddress;
  private Name emergencyContact;

  public ContactInfo(Name name, String address, String phoneNumber, String emailAddress,
      Name emergencyContact) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.emergencyContact = emergencyContact;
  }

  public Name getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public Name getEmergencyContact() {
    return emergencyContact;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(name, that.name) && Objects.equals(address,
        that.address) && Objects.equals(phoneNumber, that.phoneNumber)
        && Objects.equals(emailAddress, that.emailAddress) && Objects.equals(
        emergencyContact, that.emergencyContact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, address, phoneNumber, emailAddress, emergencyContact);
  }

  @Override
  public String toString() {
    return "ContactInfo{" +
        "name=" + name +
        ", address='" + address + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        ", emailAddress='" + emailAddress + '\'' +
        ", emergencyContact=" + emergencyContact +
        '}';
  }
}
