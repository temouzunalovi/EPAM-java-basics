package com.epam.rd.contactbook;

public class Contact {
    private String contactName;
    private ContactInfo tel;
    private Email[] emailsArray = new Email[1];
    private Social[] socialMediaArray = new Social[1];
    private final int MAX_EMAIL = 3;
    private final int MAX_SOCIAL_MEDIA = 5;
    private int emailsCount = 0;
    private int socialMediaCount = 0;

    public static class Email implements ContactInfo{
        public String firstPart;
        public String secondPart;

        public String getTitle(){
            return "Email";
        }

        public String getValue(){
            return firstPart +"@" +secondPart;
        }
    }

    public static class Social implements ContactInfo{
        public String id1;
        public String title1;
        public String getTitle(){
            return title1;
        }
        public String getValue(){
            return id1;
        }
    }

    private class NameContactInfo implements ContactInfo{
        public String getTitle(){
            return "Name";
        }
        public String getValue(){
            return "";
        }
    }

    public Contact(String contactName) {
        this.contactName = contactName;
    }

    public void rename(String newName) {
        if(newName != null && newName != "") {
            contactName = newName;
        }
    }

    public Email addEmail(String localPart, String domain) {
        if(emailsCount == MAX_EMAIL) return null;

        Email email= new Email();
        email.firstPart = localPart;
        email.secondPart = domain;

        addingEmailToArray(email);
        return email;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if(emailsCount == MAX_EMAIL) return null;

        Email email = new Email(){
            String firstPart = firstname;
            String secondPart = lastname;

            @Override
            public String getValue(){
                return firstPart + "_" + secondPart + "@epam.com";
            }
            @Override
            public String getTitle(){
                return "Epam Email";
            }
        };
        addingEmailToArray(email);
        return email;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(tel == null){
            ContactInfo phone = new ContactInfo(){
                public String getTitle(){
                    return "Tel";
                }
                public String getValue(){
                    return "+"+ code + " " + number;
                }
            };
            tel = phone;
            return phone;
        }
        else{
            return null;
        }
    }

    public Social addTwitter(String twitterId) {
        if(socialMediaCount == MAX_SOCIAL_MEDIA) return null;

        Social social = new Social(){
            public String getTitle(){
                return "Twitter";
            }
            public String getValue(){
                return twitterId;
            }
        };

        addingSocialToArray(social);
        return social;
    }

    public Social addInstagram(String instagramId) {
        if(socialMediaCount == MAX_SOCIAL_MEDIA) return null;

        Social social = new Social(){
            public String getTitle(){
                return "Instagram";
            }
            public String getValue(){
                return instagramId;
            }
        };

        addingSocialToArray(social);
        return social;
    }

    public Social addSocialMedia(String title, String id) {
        if(socialMediaCount == MAX_SOCIAL_MEDIA) return null;

        Social social = new Social(){
            public String getTitle(){
                return title;
            }
            public String getValue(){
                return id;
            }
        };

        addingSocialToArray(social);
        return social;
    }

    public ContactInfo[] getInfo() {
        int capacity = 1;
        ContactInfo[] contactArray = new ContactInfo[1];

        NameContactInfo name = new NameContactInfo(){
            public String getTitle(){
                return "Name";
            }
            public String getValue(){
                return contactName;
            }
        };

        contactArray[0] = name;


        if(tel != null){
            capacity++;
            ContactInfo[] copyArray = new ContactInfo[capacity];
            System.arraycopy(contactArray, 0, copyArray, 0, contactArray.length);

            copyArray[capacity-1]=tel;

            contactArray = new ContactInfo[capacity];
            System.arraycopy(copyArray, 0, contactArray, 0, copyArray.length);
        }

        if(emailsCount != 0){
            int oldCapacity = capacity;
            capacity+=emailsCount;

            ContactInfo[] copyArray = new ContactInfo[capacity];
            System.arraycopy(contactArray, 0, copyArray, 0, contactArray.length);

            for(int i = 0;i<emailsCount;i++){
                copyArray[oldCapacity+i] = emailsArray[i];
            }

            contactArray = new ContactInfo[capacity];
            System.arraycopy(copyArray, 0, contactArray, 0, copyArray.length);
        }

        if(socialMediaCount != 0){
            int oldCapacity = capacity;
            capacity += socialMediaCount;

            ContactInfo[] copyArray = new ContactInfo[capacity];
            System.arraycopy(contactArray, 0, copyArray, 0, contactArray.length);

            for(int i = 0;i<socialMediaCount;i++){
                copyArray[oldCapacity+i] = socialMediaArray[i];
            }

            contactArray = new ContactInfo[capacity];
            System.arraycopy(copyArray, 0, contactArray, 0, copyArray.length);
        }
        return contactArray;
    }

    private void addingEmailToArray(Email email){
        emailsCount++;

        Email[] copyArray = new Email[emailsCount];
        System.arraycopy(emailsArray, 0, copyArray, 0, emailsArray.length);

        copyArray[emailsCount-1] = email;
        emailsArray = new Email[emailsCount];

        System.arraycopy(copyArray, 0, emailsArray, 0, copyArray.length);
    }

    private void addingSocialToArray(Social social){
        socialMediaCount++;
        Social[] copyArray = new Social[socialMediaCount];
        System.arraycopy(socialMediaArray, 0, copyArray, 0, socialMediaArray.length);

        copyArray[socialMediaCount-1] = social;
        socialMediaArray = new Social[socialMediaCount];

        System.arraycopy(copyArray, 0, socialMediaArray, 0, copyArray.length);
    }

}
