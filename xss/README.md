# General Information
- The basic setup for the containers mimicks the work in ( https://www.roytuts.com/docker-compose-dockerizing-flask-mysql-app/)
- The containers use Python, Flask, and MySQL (the latter just for the app itself)
- The pages use the carousel example from (https://getbootstrap.com/docs/5.2/examples/) for the vulnerable XSS page
- We also used bootstrap (https://getbootstrap.com/docs/5.2/) for the login/registration page

# Containers
- The `app` container is the vulnerable system.  It has a home page that has a vulnerable search element. (Note that to make this vulnerable, we needed to use the *safe* keyword in the `search.html` file where the search query is obtained.  This is to make the XSS part of this easy.)
- The `attacker-iframe` container shows how the attack would work if the browser didn't block cross-origin frames (which modern browsers all do by default now).
- The `attacker-redirect` shows a way to execute the attack by changing all the *href* attributes to the header *a* tags to the attacker container.  After attempting the login, the user is redirected to the correct login page.
