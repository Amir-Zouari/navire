import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app/app.module';


platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
document.addEventListener("DOMContentLoaded", function(event) {
    const showNavbar = (toggleId: string, navId: string, bodyId: string, headerId: string) => {
        const toggle = document.getElementById(toggleId),
            nav = document.getElementById(navId),
            bodypd = document.getElementById(bodyId),
            headerpd = document.getElementById(headerId);
        
        // Validate that all variables exist
        if (toggle && nav && bodypd && headerpd) {
            toggle.addEventListener('click', () => {
                // show navbar
                nav.classList.toggle('show');
                // change icon
                toggle.classList.toggle('bx-x');
                // add padding to body
                bodypd.classList.toggle('body-pd');
                // add padding to header
                headerpd.classList.toggle('body-pd');
            });
        }
    }
    
    showNavbar('header-toggle','nav-bar','body-pd','header');
    
    /*===== LINK ACTIVE =====*/
    const linkColor = document.querySelectorAll('.nav_link');

function colorLink(element: Element) {
  linkColor.forEach(l => l.classList.remove('active'));
  element.classList.add('active');
}

linkColor.forEach(l => l.addEventListener('click', () => colorLink(l)));
    
    // Your code to run since DOM is loaded and ready
});