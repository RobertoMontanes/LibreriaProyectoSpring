const toggle = document.createElement('button');
toggle.innerHTML = '🌓';
toggle.className = 'btn btn-secondary position-fixed top-0 end-0 m-3';
document.body.appendChild(toggle);

toggle.addEventListener('click', () => {
    document.body.classList.toggle('dark-mode');
});
