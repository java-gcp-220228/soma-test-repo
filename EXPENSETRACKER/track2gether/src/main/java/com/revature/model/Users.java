package model;

import javax.persistence.*;
import java.util.Objects;


    @Entity
    @Table(name="users")
    public class Users {
        @Id
        @SequenceGenerator(name="mysequence", initialValue=1)
        @GeneratedValue( strategy = GenerationType.IDENTITY, generator="mysequence")
        private  int id;
        @Column(name= "firstname", nullable=false)
        private String firstname;
        @Column(name= "lastname", nullable=false)
        private String lastname;

        public Users() {
        }
        @Column(name= "email")
        private String email;

   /* @OneToOne
    @JoinColumn(name="spouseid")
    @JsonManagedReference
     private Users spouseId;*/

        public Users(int id, String firstname, String lastname, String email, Users spouseId) {
            this.id = id;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            // this.spouseId = spouseId;
        }

        public Users(String firstname, String lastname, String email, Users spouseId) {
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            //this.spouseId = spouseId;
        }

        @Override
        public String toString() {
            return "Users{" +
                    "id=" + id +
                    ", firstname='" + firstname + '\'' +
                    ", lastname='" + lastname + '\'' +
                    ", email='" + email + '\'' +
                    /*  ", spouseId=" + spouseId +*/
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Users)) return false;
            Users users = (Users) o;
            return getId() == users.getId() && Objects.equals(getFirstname(), users.getFirstname()) && Objects.equals(getLastname(), users.getLastname()) && Objects.equals(getEmail(), users.getEmail());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getFirstname(), getLastname(), getEmail());
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }


    }


