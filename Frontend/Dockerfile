FROM node:20.11.0

WORKDIR /usr/src/app

COPY . /usr/src/app

RUN npm install -g @angular/cli

RUN npm install --force

CMD ["ng", "serve", "--host", "0.0.0.0"]